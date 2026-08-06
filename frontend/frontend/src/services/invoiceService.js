const API_URL = "http://localhost:8080/api/invoices";

export async function saveInvoice(invoice) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(API_URL, {

        method: "POST",

        headers: {

            Authorization: `Bearer ${token}`,

            "Content-Type": "application/json"

        },

        body: JSON.stringify(invoice)

    });

    if (!response.ok) {

        throw new Error("Unable to save invoice.");

    }

    return await response.json();

}

export async function getInvoice(id) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(`${API_URL}/${id}`, {

        headers: {

            Authorization: `Bearer ${token}`

        }

    });

    if (!response.ok) {

        throw new Error("Unable to load invoice.");

    }

    return await response.json();

}