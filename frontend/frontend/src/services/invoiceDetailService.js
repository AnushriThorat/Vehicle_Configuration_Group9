const API_URL = "http://localhost:8080/api/invoice-details";

export async function saveInvoiceDetail(invoiceDetail) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(API_URL, {

        method: "POST",

        headers: {

            Authorization: `Bearer ${token}`,

            "Content-Type": "application/json"

        },

        body: JSON.stringify(invoiceDetail)

    });

    if (!response.ok) {

        throw new Error("Unable to save invoice detail.");

    }

    return await response.json();

}

export async function getInvoiceDetails(invoiceId) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(

        `${API_URL}/invoice/${invoiceId}`,

        {

            headers: {

                Authorization: `Bearer ${token}`

            }

        }

    );

    if (!response.ok) {

        throw new Error("Unable to load invoice details.");

    }

    return await response.json();

}