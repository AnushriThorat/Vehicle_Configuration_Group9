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
import {
  saveInvoiceDetail,
  getInvoiceDetails
} from "../services/invoiceDetailService";

import "./invoice.css";

const invoiceNumber =
  `INV-${new Date().getFullYear()}${String(
    new Date().getMonth() + 1
  ).padStart(2, "0")}${String(
    new Date().getDate()
  ).padStart(2, "0")}-${Math.floor(100000 + Math.random() * 900000)}`;

const Invoice = () => {

  const navigate = useNavigate();
  const location = useLocation();

  const invoiceRef = useRef(null);

  const [user, setUser] = useState(null);
  const [invoice, setInvoice] = useState(null);
  const [invoiceDetails, setInvoiceDetails] = useState([]);
  const [loading, setLoading] = useState(false);
  const [showSuccess, setShowSuccess] = useState(false);

  const {

    vehicle,

    quantity,

    minimumQuantity,

    selectedComponents,

    additionalPrice,

    grandTotal

  } = location.state;

  const TAX_RATE = 12;

  const vehicleAmount =
    Number(vehicle.basePrice) * Number(quantity);

  const additionalAmount =
    Object.values(selectedComponents || {}).reduce(

      (sum, item) =>
        sum + (item.deltaPrice * quantity),

      0

    );

  const subtotal =
    vehicleAmount + additionalAmount;

  const tax =
    subtotal * TAX_RATE / 100;

  const total =
    subtotal + tax;

  const invoiceBody = {

    invDate: new Date().toISOString(),

    model: {

      modelId: vehicle.modelId

    },

    user: {

      id: Number(sessionStorage.getItem("userId"))

    },

    totalAmt: subtotal,

    tax,

    netAmt: total

  };

  const formatCurrency = (amount) =>

    Number(amount).toLocaleString("en-IN", {

      minimumFractionDigits: 2,

      maximumFractionDigits: 2

    });

  const loadUser = async () => {

    try {

      const data = await getUser(
        Number(sessionStorage.getItem("userId"))
      );

      setUser(data);

    }

    catch (err) {

      console.error(err);

    }

  };

  useEffect(() => {

    loadUser();

  }, []);

  const handleConfirmOrder = async () => {

  try {

    setLoading(true);

    const savedInvoice = await saveInvoice(invoiceBody);

    setInvoice(savedInvoice);

    await handleDownloadPDF(true);

    const detailPromises = Object.values(selectedComponents || {}).map(
      (component) => {

        const payload = {

          invoice: {
            invId: savedInvoice.invId
          },

          component: {
            compId: component.compId
          },

          alternateComponent: {
            compId: component.altCompId
          },

          deltaPrice: component.deltaPrice,

          model: {
            modelId: vehicle.modelId
          }

        };

        console.log("Invoice Detail Payload :", payload);

        return saveInvoiceDetail(payload);

      }
    );

    await Promise.all(detailPromises);

    const details =
      await getInvoiceDetails(savedInvoice.invId);

    setInvoiceDetails(details);

    setShowSuccess(true);

  }

  catch (error) {

    console.error("Invoice Error :", error);

    alert(error.message);

  }

  finally {

    setLoading(false);

  }

};

const handleDownloadPDF = async (sendMail = false) => {

  if (!invoiceRef.current) return;

  const canvas = await html2canvas(invoiceRef.current, {
    scale: 1.3,
    useCORS: true
  });

  const imgData = canvas.toDataURL("image/jpeg", 0.8);

  const pdf = new jsPDF("p", "mm", "a4");

  const pdfWidth = pdf.internal.pageSize.getWidth();

  const pdfHeight =
    (canvas.height * pdfWidth) / canvas.width;

  pdf.addImage(
    imgData,
    "JPEG",
    0,
    0,
    pdfWidth,
    pdfHeight
  );

  if (!sendMail) {

    pdf.save(`${invoiceNumber}.pdf`);

    return;

  }

  const pdfBlob = pdf.output("blob");

  await sendInvoiceMail(
    user.companyEmail,
    invoiceNumber,
    pdfBlob
  );

};
return (
  <div className="page-shell">
    <Header isAuthenticated={true} />

    <main className="invoice-page">
      {/* ================= PRINTABLE AREA ================= */}
      <div className="invoice-container" ref={invoiceRef}>
        {/* ================= HEADER ================= */}
        <div className="invoice-header">
          <div className="company-section">
            <img
              src="/images/logo.jpeg"
              alt="9 Wheels"
              className="company-logo"
            />

            <div className="company-details">
              <h2>9 Wheels Leasing Services Pvt. Ltd.</h2>

              <p>
                221B, Assembly Road, Pune,
                Maharashtra - 411001, India
              </p>

              <p>Phone : +91 98765 43210</p>

              <p>Email : sales@9wheels.com</p>

              <p>GST No. : 27ABCDE1234F1Z5</p>
            </div>
          </div>

          <div className="invoice-title">
            <h1>INVOICE</h1>

            <p>
              <strong>Invoice No :</strong> {invoiceNumber}
            </p>

            <p>
              <strong>Invoice Date :</strong>{" "}
              {new Date().toLocaleDateString("en-GB")}
            </p>
          </div>
        </div>

        {/* ================= CUSTOMER + VEHICLE ================= */}
        <div className="invoice-info">
          <div className="shipping-address">
            <h3>SHIP TO</h3>

            <p>
              <strong>{user?.companyName}</strong>
            </p>

            <p>{user?.username}</p>

            <p>{user?.add1}</p>

            <p>{user?.add2}</p>

            <p>
              {user?.city}, {user?.state}
            </p>

            <p>PIN : {user?.pin}</p>

            <p>Phone : {user?.phone}</p>

            <p>Email : {user?.companyEmail}</p>
          </div>

          <div className="vehicle-section">
            <h3>VEHICLE DETAILS</h3>

            <div className="vehicle-content">
              <img
                src={`/${vehicle.imagePath}`}
                alt={vehicle.modelName}
                className="invoice-vehicle-image"
              />

              <div className="vehicle-meta">
                <p>
                  <strong>Model :</strong> {vehicle.modelName}
                </p>

                <p>
                  <strong>Manufacturer :</strong> {vehicle.mfgName}
                </p>

                <p>
                  <strong>Segment :</strong> {vehicle.segName}
                </p>

                <p>
                  <strong>Quantity :</strong> {quantity} Units
                </p>
              </div>
            </div>
          </div>
        </div>

        {/* ================= INVOICE ITEMS ================= */}
        <table className="invoice-table">
          <thead>
            <tr>
              <th>#</th>
              <th>Description</th>
              <th>Qty</th>
              <th>Rate (₹)</th>
              <th>Amount (₹)</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td>1</td>

              <td>
                {vehicle.modelName}
                <br />
                <small>Base Vehicle</small>
              </td>

              <td>{quantity}</td>

              <td>{formatCurrency(vehicle.basePrice)}</td>

              <td>{formatCurrency(vehicleAmount)}</td>
            </tr>

            {Object.values(selectedComponents || {}).map(
              (component, index) => (
                <tr key={component.altId}>
                  <td>{index + 2}</td>

                  <td>
                    {component.alternateComponentName}
                    <br />
                    <small>
                      Replaces {component.componentName}
                    </small>
                  </td>

                  <td>{quantity}</td>

                  <td>{formatCurrency(component.deltaPrice)}</td>

                  <td>
                    {formatCurrency(
                      component.deltaPrice * quantity
                    )}
                  </td>
                </tr>
              )
            )}
          </tbody>
        </table>

        {/* ================= TOTALS ================= */}
        <div className="invoice-summary">
          <div className="summary-box">
            <div className="summary-row">
              <span>Vehicle Amount</span>

              <strong>
                ₹ {formatCurrency(vehicleAmount)}
              </strong>
            </div>

            <div className="summary-row">
              <span>Additional Components</span>

              <strong>
                ₹ {formatCurrency(additionalAmount)}
              </strong>
            </div>

            <div className="summary-row">
              <span>Sub Total</span>

              <strong>
                ₹ {formatCurrency(subtotal)}
              </strong>
            </div>

            <div className="summary-row">
              <span>GST (12%)</span>

              <strong>
                ₹ {formatCurrency(tax)}
              </strong>
            </div>

            <div className="summary-total">
              <span>GRAND TOTAL</span>

              <strong>
                ₹ {formatCurrency(total)}
              </strong>
            </div>
          </div>
        </div>
      </div>
            {/* ================= BUTTONS (NOT PRINTED / NOT IN PDF) ================= */}
      <div className="invoice-buttons no-print">
        <button
          className="print-btn"
          onClick={() => window.print()}
        >
          Print Invoice
        </button>

        <button
          className="download-btn"
          onClick={() => handleDownloadPDF(false)}
        >
          Download PDF
        </button>

        <button
          className="confirm-btn"
          onClick={handleConfirmOrder}
          disabled={loading}
        >
          {loading ? "Saving..." : "Confirm Order"}
        </button>
      </div>
    </main>

    <Footer />

    {showSuccess && (
      <OrderSuccessModal
        onFinish={() => navigate("/")}
      />
    )}
  </div>
);

};

export default Invoice;