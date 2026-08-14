const API_URL =
    `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/invoice/send-mail`;

// =====================================================
// SEND INVOICE MAIL
//
// .NET expects:
// {
//     Email,
//     Subject,
//     Body,
//     Pdf,
//     FileName
// }
// =====================================================

export async function sendInvoiceMail(
    email,
    invoiceNo,
    pdfBlob
) {
    const token = sessionStorage.getItem("token");

    if (!email) {
        throw new Error("Email address is required.");
    }

    if (!pdfBlob) {
        throw new Error("Invoice PDF is required.");
    }

    try {

        // ---------------------------------------------
        // Convert PDF Blob → Base64
        // ---------------------------------------------

        const pdfBase64 = await blobToBase64(pdfBlob);


        // ---------------------------------------------
        // Create request body
        // ---------------------------------------------

        const request = {
            Email: email,

            Subject: `Invoice ${invoiceNo}`,

            Body:
                `Dear Customer,\n\n` +
                `Please find the attached invoice ${invoiceNo}.\n\n` +
                `Thank you for choosing 9 Wheels Leasing Services Pvt. Ltd.\n\n` +
                `Regards,\n` +
                `9 Wheels Leasing Services Pvt. Ltd.`,

            Pdf: pdfBase64,

            FileName: `${invoiceNo}.pdf`
        };


        console.log(
            "Invoice Mail Request:",
            {
                Email: request.Email,
                Subject: request.Subject,
                FileName: request.FileName
            }
        );


        // ---------------------------------------------
        // Send request
        // ---------------------------------------------

        const response = await fetch(
            API_URL,
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${token}`
                },

                body: JSON.stringify(request)
            }
        );


        // ---------------------------------------------
        // Handle error
        // ---------------------------------------------

        if (!response.ok) {

            const errorMessage =
                await response.text();

            throw new Error(
                errorMessage ||
                "Unable to send invoice mail."
            );
        }


        // ---------------------------------------------
        // Return response
        // ---------------------------------------------

        return await response.json();

    } catch (error) {

        console.error(
            "Error sending invoice mail:",
            error
        );

        throw error;
    }
}


// =====================================================
// BLOB → BASE64
// =====================================================

function blobToBase64(blob) {

    return new Promise(
        (resolve, reject) => {

            const reader =
                new FileReader();

            reader.onloadend = () => {

                const result =
                    reader.result;

                // -------------------------------------
                // FileReader returns:
                //
                // data:application/pdf;base64,XXXXX
                //
                // We only need XXXXX
                // -------------------------------------

                const base64 =
                    result.split(",")[1];

                resolve(base64);
            };

            reader.onerror = () => {

                reject(
                    new Error(
                        "Unable to convert PDF to Base64."
                    )
                );
            };

            reader.readAsDataURL(blob);
        }
    );
}