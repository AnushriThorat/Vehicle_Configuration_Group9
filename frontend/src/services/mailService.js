const API_URL = `${import.meta.env.VITE_API_BASE_URL}/api/mail/send-invoice`;

export async function sendInvoiceMail(email, invoiceNo, pdfBlob) {

    const token = sessionStorage.getItem("token");

    const formData = new FormData();

    formData.append("email", email);

    formData.append("invoiceNo", invoiceNo);

    formData.append(
        "pdf",
        pdfBlob,
        `${invoiceNo}.pdf`
    );

    const response = await fetch(API_URL, {

        method: "POST",

        headers: {

            Authorization: `Bearer ${token}`

        },

        body: formData

    });

    if (!response.ok) {

        throw new Error("Unable to send invoice mail.");

    }

    return await response.text();

}