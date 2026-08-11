import { useEffect, useState, useRef } from "react";
import { useLocation, useNavigate } from "react-router-dom";

import jsPDF from "jspdf";
import html2canvas from "html2canvas";

import { sendInvoiceMail } from "../services/mailService";

import Header from "../components/Header";
import Footer from "../components/Footer";
import OrderSuccessModal from "../components/OrderSuccessModal";

import { getUser } from "../services/userService";
import { saveInvoice } from "../services/invoiceService";
import { getInvoiceDetails } from "../services/invoiceDetailService";

import "./invoice.css";


// =====================================================
// FRONTEND INVOICE NUMBER
// =====================================================

const invoiceNumber =
    `INV-${new Date().getFullYear()}${String(
        new Date().getMonth() + 1
    ).padStart(2, "0")}${String(
        new Date().getDate()
    ).padStart(2, "0")}-${Math.floor(
        100000 + Math.random() * 900000
    )}`;


// =====================================================
// COMPONENT
// =====================================================

const Invoice = () => {

    const navigate = useNavigate();
    const location = useLocation();

    const invoiceRef = useRef(null);


    // =================================================
    // STATE
    // =================================================

    const [user, setUser] = useState(null);

    const [invoice, setInvoice] = useState(null);

    const [invoiceDetails, setInvoiceDetails] = useState([]);

    const [loading, setLoading] = useState(false);

    const [showSuccess, setShowSuccess] = useState(false);

    const [userLoading, setUserLoading] = useState(true);

    const [userError, setUserError] = useState("");

    const [invoiceError, setInvoiceError] = useState("");


    // =================================================
    // GET DATA FROM CONFIGURE / VEHICLE DETAILS PAGE
    // =================================================

    const {
        vehicle,
        quantity,
        minimumQuantity,
        selectedComponents,
        additionalPrice,
        grandTotal
    } = location.state || {};


    // =================================================
    // SAFETY CHECK
    // =================================================

    if (!vehicle) {

        return (
            <div className="page-shell">

                <Header isAuthenticated={true} />

                <main className="invoice-page">

                    <h2>
                        Vehicle information is missing.
                    </h2>

                    <button
                        onClick={() => navigate("/")}
                    >
                        Go Home
                    </button>

                </main>

                <Footer />

            </div>
        );
    }


    // =================================================
    // NORMALIZE QUANTITY
    // =================================================

    const selectedQuantity =
        Number(quantity) > 0
            ? Number(quantity)
            : 1;


    // =================================================
    // TAX
    // .NET InvoiceService uses 18% GST
    // =================================================

    const TAX_RATE = 18;


    // =================================================
    // VEHICLE AMOUNT
    // =================================================

    const vehicleAmount =
        Number(vehicle.basePrice || 0) *
        selectedQuantity;


    // =================================================
    // ADDITIONAL COMPONENT AMOUNT
    // =================================================

    const additionalAmount =
        Object.values(selectedComponents || {}).reduce(
            (sum, item) =>
                sum +
                (
                    Number(item?.deltaPrice || 0) *
                    selectedQuantity
                ),
            0
        );


    // =================================================
    // SUBTOTAL
    // =================================================

    const subtotal =
        vehicleAmount + additionalAmount;


    // =================================================
    // TAX
    // =================================================

    const tax =
        subtotal * TAX_RATE / 100;


    // =================================================
    // GRAND TOTAL
    // =================================================

    const total =
        subtotal + tax;


    // =================================================
    // FORMAT CURRENCY
    // =================================================

    const formatCurrency = (amount) =>
        Number(amount || 0).toLocaleString(
            "en-IN",
            {
                minimumFractionDigits: 2,
                maximumFractionDigits: 2
            }
        );


    // =================================================
    // GET USER ID
    // =================================================

    const getLoggedInUserId = () => {

        const storedUserId =
            sessionStorage.getItem("userId");

        if (
            storedUserId === null ||
            storedUserId === undefined ||
            storedUserId.trim() === ""
        ) {
            return null;
        }

        const userId =
            Number(storedUserId);

        if (
            !Number.isInteger(userId) ||
            userId <= 0
        ) {
            return null;
        }

        return userId;
    };


    // =================================================
    // LOAD USER
    // =================================================

    const loadUser = async () => {

        setUserLoading(true);
        setUserError("");

        try {

            const userId =
                getLoggedInUserId();


            // -----------------------------------------
            // USER ID VALIDATION
            // -----------------------------------------

            if (!userId) {

                console.error(
                    "User ID not found in session."
                );

                setUserError(
                    "User information is unavailable. Please login again."
                );

                return;
            }


            console.log(
                "Logged-in User ID:",
                userId
            );


            // -----------------------------------------
            // GET USER
            // -----------------------------------------

            const data =
                await getUser(userId);


            console.log(
                "User Data:",
                data
            );


            setUser(data);

        }
        catch (error) {

            console.error(
                "Unable to load user:",
                error
            );

            setUserError(
                "Unable to load user information."
            );

        }
        finally {

            setUserLoading(false);

        }
    };


    // =================================================
    // LOAD USER ON PAGE LOAD
    // =================================================

    useEffect(() => {

        loadUser();

    }, []);


    // =================================================
    // GENERATE INVOICE REQUEST
    // =================================================
    //
    // Matches .NET InvoiceRequestDto:
    //
    // {
    //     modelId,
    //     userId,
    //     items
    // }
    //
    // =================================================

    const buildInvoiceRequest = () => {

        // -----------------------------------------
        // GET USER ID
        // -----------------------------------------

        const userId =
            getLoggedInUserId();


        if (!userId) {

            throw new Error(
                "User ID not found. Please login again."
            );
        }


        // -----------------------------------------
        // MODEL ID
        // -----------------------------------------

        const modelId =
            Number(vehicle?.modelId);


        if (
            !Number.isInteger(modelId) ||
            modelId <= 0
        ) {

            throw new Error(
                "Invalid vehicle model ID."
            );
        }


        // -----------------------------------------
        // BUILD ITEMS
        // -----------------------------------------

        const items =
            Object.values(
                selectedComponents || {}
            )
            .filter(
                component =>
                    component &&
                    component.compId
            )
            .map(component => ({

                compId:
                    Number(component.compId),

                altCompId:
                    Number(
                        component.altCompId ??
                        component.compId
                    ),

                deltaPrice:
                    Number(
                        component.deltaPrice || 0
                    )

            }));


        // -----------------------------------------
        // FINAL REQUEST
        // -----------------------------------------

        const request = {

            modelId: modelId,

            userId: userId,

            items: items

        };


        console.log(
            "Final Invoice Request:",
            request
        );


        return request;
    };


    // =================================================
    // CONFIRM ORDER
    // =================================================

    const handleConfirmOrder = async () => {

        try {

            setLoading(true);

            setInvoiceError("");


            // -----------------------------------------
            // CHECK USER
            // -----------------------------------------

            const userId =
                getLoggedInUserId();


            if (!userId) {

                throw new Error(
                    "User ID not found. Please logout and login again."
                );
            }


            // -----------------------------------------
            // CHECK USER DATA
            // -----------------------------------------

            if (!user) {

                await loadUser();

            }


            // -----------------------------------------
            // BUILD REQUEST
            // -----------------------------------------

            const invoiceRequest =
                buildInvoiceRequest();


            console.log(
                "Invoice Request:",
                invoiceRequest
            );


            // -----------------------------------------
            // SAVE INVOICE
            // -----------------------------------------

            const savedInvoice =
                await saveInvoice(
                    invoiceRequest
                );


            console.log(
                "Invoice Saved:",
                savedInvoice
            );


            setInvoice(savedInvoice);


            // -----------------------------------------
            // GET INVOICE ID
            // -----------------------------------------

            const invoiceId =
                savedInvoice?.header?.invId ??
                savedInvoice?.header?.invoiceId ??
                savedInvoice?.invId ??
                savedInvoice?.invoiceId;


            if (!invoiceId) {

                throw new Error(
                    "Invoice was created but Invoice ID was not returned."
                );
            }


            console.log(
                "Generated Invoice ID:",
                invoiceId
            );


            // -----------------------------------------
            // GET COMPLETE INVOICE DETAILS
            // -----------------------------------------

            try {

                const details =
                    await getInvoiceDetails(
                        invoiceId
                    );


                console.log(
                    "Invoice Details:",
                    details
                );


                setInvoiceDetails(
                    Array.isArray(details)
                        ? details
                        : details?.details || []
                );

            }
            catch (detailError) {

                console.warn(
                    "Unable to load invoice details:",
                    detailError
                );

                // Do not stop invoice generation
                // because the invoice itself is already saved.

                setInvoiceDetails([]);

            }


            // -----------------------------------------
            // GENERATE PDF AND SEND MAIL
            // -----------------------------------------

            await handleDownloadPDF(true);


            // -----------------------------------------
            // SHOW SUCCESS
            // -----------------------------------------

            setShowSuccess(true);

        }
        catch (error) {

            console.error(
                "Invoice Error:",
                error
            );


            setInvoiceError(
                error?.message ||
                "Unable to generate invoice."
            );


            alert(
                error?.message ||
                "Unable to generate invoice."
            );

        }
        finally {

            setLoading(false);

        }
    };


    // =================================================
    // GENERATE PDF
    // =================================================

    const handleDownloadPDF = async (
        sendMail = false
    ) => {

        if (!invoiceRef.current) {

            throw new Error(
                "Invoice content is not available."
            );
        }


        // -----------------------------------------
        // HTML → CANVAS
        // -----------------------------------------

        const canvas =
            await html2canvas(
                invoiceRef.current,
                {
                    scale: 1.3,
                    useCORS: true,
                    backgroundColor: "#ffffff"
                }
            );


        // -----------------------------------------
        // CANVAS → IMAGE
        // -----------------------------------------

        const imgData =
            canvas.toDataURL(
                "image/jpeg",
                0.8
            );


        // -----------------------------------------
        // CREATE PDF
        // -----------------------------------------

        const pdf =
            new jsPDF(
                "p",
                "mm",
                "a4"
            );


        const pdfWidth =
            pdf.internal.pageSize.getWidth();


        const pdfHeight =
            (
                canvas.height *
                pdfWidth
            ) /
            canvas.width;


        pdf.addImage(
            imgData,
            "JPEG",
            0,
            0,
            pdfWidth,
            pdfHeight
        );


        // -----------------------------------------
        // NORMAL DOWNLOAD
        // -----------------------------------------

        if (!sendMail) {

            pdf.save(
                `${invoiceNumber}.pdf`
            );

            return;
        }


        // -----------------------------------------
        // SEND PDF BY MAIL
        // -----------------------------------------

        const email =
            user?.companyEmail;


        if (!email) {

            throw new Error(
                "User email address is not available."
            );
        }


        const pdfBlob =
            pdf.output("blob");


        console.log(
            "Sending invoice PDF to:",
            email
        );


        await sendInvoiceMail(
            email,
            invoiceNumber,
            pdfBlob
        );


        console.log(
            "Invoice mail sent successfully."
        );
    };


    // =================================================
    // USER DISPLAY VALUES
    // =================================================

    const customerName =
        user?.authName ||
        user?.username ||
        user?.companyName ||
        "N/A";


    const customerMobile =
        user?.cell ||
        user?.phone ||
        user?.authTel ||
        "N/A";


    const customerEmail =
        user?.companyEmail ||
        "N/A";


    // =================================================
    // MANUFACTURER
    // =================================================

    const manufacturerName =
        vehicle?.mfgName ||
        vehicle?.manufacturerName ||
        "N/A";


    // =================================================
    // SEGMENT
    // =================================================

    const segmentName =
        vehicle?.segmentName ||
        vehicle?.segName ||
        "N/A";


    // =================================================
    // RENDER
    // =================================================

    return (

        <div className="page-shell">

            <Header isAuthenticated={true} />


            <main className="invoice-page">


                {/* =====================================
                    USER ERROR
                ====================================== */}

                {userError && (

                    <div
                        className="invoice-error no-print"
                    >
                        {userError}
                    </div>

                )}


                {/* =====================================
                    INVOICE ERROR
                ====================================== */}

                {invoiceError && (

                    <div
                        className="invoice-error no-print"
                    >
                        {invoiceError}
                    </div>

                )}


                {/* =====================================
                    PRINTABLE INVOICE
                ====================================== */}

                <div
                    className="invoice-container"
                    ref={invoiceRef}
                >


                    {/* =================================
                        HEADER
                    ================================== */}

                    <div className="invoice-header">

                        <div className="company-section">

                            <img
                                src="/images/logo.jpeg"
                                alt="9 Wheels"
                                className="company-logo"
                            />


                            <div className="company-details">

                                <h2>
                                    9 Wheels Leasing
                                    Services Pvt. Ltd.
                                </h2>

                                <p>
                                    221B, Assembly Road,
                                    Pune,
                                    Maharashtra - 411001,
                                    India
                                </p>

                                <p>
                                    Phone : +91 98765 43210
                                </p>

                                <p>
                                    Email :
                                    sales@9wheels.com
                                </p>

                                <p>
                                    GST No. :
                                    27ABCDE1234F1Z5
                                </p>

                            </div>

                        </div>


                        <div className="invoice-title">

                            <h1>
                                INVOICE
                            </h1>

                            <p>
                                <strong>
                                    Invoice No :
                                </strong>{" "}
                                {invoiceNumber}
                            </p>

                            <p>
                                <strong>
                                    Invoice Date :
                                </strong>{" "}
                                {new Date()
                                    .toLocaleDateString(
                                        "en-GB"
                                    )}
                            </p>

                        </div>

                    </div>


                    {/* =================================
                        CUSTOMER + VEHICLE
                    ================================== */}

                    <div className="invoice-info">


                        {/* =================================
                            CUSTOMER
                        ================================== */}

                        <div className="shipping-address">

                            <h3>
                                SHIP TO
                            </h3>


                            <p>
                                <strong>
                                    Name :
                                </strong>{" "}
                                {customerName}
                            </p>


                            <p>
                                <strong>
                                    Mobile :
                                </strong>{" "}
                                {customerMobile}
                            </p>


                            <p>
                                <strong>
                                    Email :
                                </strong>{" "}
                                {customerEmail}
                            </p>

                        </div>


                        {/* =================================
                            VEHICLE
                        ================================== */}

                        <div className="vehicle-section">

                            <h3>
                                VEHICLE DETAILS
                            </h3>


                            <div className="vehicle-content">

                                <img
                                    src={`/${vehicle.imagePath}`}
                                    alt={
                                        vehicle.modelName ||
                                        "Vehicle"
                                    }
                                    className="invoice-vehicle-image"
                                    onError={(e) => {
                                        console.error(
                                            "Vehicle image failed:",
                                            e.target.src
                                        );
                                    }}
                                />


                                <div className="vehicle-meta">

                                    <p>
                                        <strong>
                                            Model :
                                        </strong>{" "}
                                        {
                                            vehicle.modelName ||
                                            "N/A"
                                        }
                                    </p>


                                    <p>
                                        <strong>
                                            Manufacturer :
                                        </strong>{" "}
                                        {
                                            manufacturerName
                                        }
                                    </p>


                                    <p>
                                        <strong>
                                            Segment :
                                        </strong>{" "}
                                        {
                                            segmentName
                                        }
                                    </p>


                                    <p>
                                        <strong>
                                            Quantity :
                                        </strong>{" "}
                                        {
                                            selectedQuantity
                                        } Units
                                    </p>

                                </div>

                            </div>

                        </div>

                    </div>


                    {/* =================================
                        INVOICE ITEMS
                    ================================== */}

                    <table className="invoice-table">

                        <thead>

                            <tr>

                                <th>
                                    #
                                </th>

                                <th>
                                    Description
                                </th>

                                <th>
                                    Qty
                                </th>

                                <th>
                                    Rate (₹)
                                </th>

                                <th>
                                    Amount (₹)
                                </th>

                            </tr>

                        </thead>


                        <tbody>


                            {/* =================================
                                BASE VEHICLE
                            ================================== */}

                            <tr>

                                <td>
                                    1
                                </td>

                                <td>

                                    {
                                        vehicle.modelName ||
                                        "Vehicle"
                                    }

                                    <br />

                                    <small>
                                        Base Vehicle
                                    </small>

                                </td>

                                <td>
                                    {selectedQuantity}
                                </td>

                                <td>
                                    {formatCurrency(
                                        vehicle.basePrice
                                    )}
                                </td>

                                <td>
                                    {formatCurrency(
                                        vehicleAmount
                                    )}
                                </td>

                            </tr>


                            {/* =================================
                                SELECTED COMPONENTS
                            ================================== */}

                            {Object.values(
                                selectedComponents || {}
                            ).map(
                                (
                                    component,
                                    index
                                ) => (

                                    <tr
                                        key={
                                            component?.altId ??
                                            `${component?.compId}-${component?.altCompId}-${index}`
                                        }
                                    >

                                        <td>
                                            {index + 2}
                                        </td>

                                        <td>

                                            {
                                                component?.alternateComponentName ||
                                                component?.componentName ||
                                                "Additional Component"
                                            }

                                            <br />

                                            <small>
                                                Replaces{" "}
                                                {
                                                    component?.componentName ||
                                                    "Original Component"
                                                }
                                            </small>

                                        </td>

                                        <td>
                                            {
                                                selectedQuantity
                                            }
                                        </td>

                                        <td>
                                            {formatCurrency(
                                                component?.deltaPrice
                                            )}
                                        </td>

                                        <td>
                                            {formatCurrency(
                                                Number(
                                                    component?.deltaPrice ||
                                                    0
                                                ) *
                                                selectedQuantity
                                            )}
                                        </td>

                                    </tr>

                                )
                            )}

                        </tbody>

                    </table>


                    {/* =================================
                        TOTALS
                    ================================== */}

                    <div className="invoice-summary">

                        <div className="summary-box">


                            <div className="summary-row">

                                <span>
                                    Vehicle Amount
                                </span>

                                <strong>
                                    ₹{" "}
                                    {formatCurrency(
                                        vehicleAmount
                                    )}
                                </strong>

                            </div>


                            <div className="summary-row">

                                <span>
                                    Additional Components
                                </span>

                                <strong>
                                    ₹{" "}
                                    {formatCurrency(
                                        additionalAmount
                                    )}
                                </strong>

                            </div>


                            <div className="summary-row">

                                <span>
                                    Sub Total
                                </span>

                                <strong>
                                    ₹{" "}
                                    {formatCurrency(
                                        subtotal
                                    )}
                                </strong>

                            </div>


                            <div className="summary-row">

                                <span>
                                    GST (18%)
                                </span>

                                <strong>
                                    ₹{" "}
                                    {formatCurrency(
                                        tax
                                    )}
                                </strong>

                            </div>


                            <div className="summary-total">

                                <span>
                                    GRAND TOTAL
                                </span>

                                <strong>
                                    ₹{" "}
                                    {formatCurrency(
                                        total
                                    )}
                                </strong>

                            </div>

                        </div>

                    </div>


                </div>


                {/* =====================================
                    BUTTONS
                ====================================== */}

                <div className="invoice-buttons no-print">

                    <button
                        className="print-btn"
                        onClick={() =>
                            window.print()
                        }
                        disabled={loading}
                    >
                        Print Invoice
                    </button>


                    <button
                        className="download-btn"
                        onClick={() =>
                            handleDownloadPDF(false)
                        }
                        disabled={loading}
                    >
                        Download PDF
                    </button>


                    <button
                        className="confirm-btn"
                        onClick={
                            handleConfirmOrder
                        }
                        disabled={
                            loading ||
                            userLoading
                        }
                    >
                        {
                            loading
                                ? "Saving..."
                                : userLoading
                                    ? "Loading User..."
                                    : "Confirm Order"
                        }
                    </button>

                </div>


            </main>


            <Footer />


            {/* =====================================
                SUCCESS MODAL
            ====================================== */}

            {showSuccess && (

                <OrderSuccessModal
                    onFinish={() =>
                        navigate("/")
                    }
                />
            )}
        </div>
    );
};


export default Invoice;