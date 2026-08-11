const API_URL =
    `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/invoice`;

// =====================================================
// GENERATE INVOICE
// POST /api/invoice/generate
// =====================================================

export async function saveInvoice(invoice) {

    const token = sessionStorage.getItem("token");

    try {

        const response = await fetch(
            `${API_URL}/generate`,
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${token}`
                },

                body: JSON.stringify(invoice)
            }
        );

        if (!response.ok) {

            const errorMessage = await response.text();

            throw new Error(
                errorMessage || "Unable to generate invoice."
            );
        }

        return await response.json();

    } catch (error) {

        console.error(
            "Error generating invoice:",
            error
        );

        throw error;
    }
}


// =====================================================
// GET INVOICE
// GET /api/invoice/{invoiceId}
// =====================================================

export async function getInvoice(invoiceId) {

    const token = sessionStorage.getItem("token");

    try {

        const response = await fetch(
            `${API_URL}/${invoiceId}`,
            {
                method: "GET",

                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${token}`
                }
            }
        );

        if (!response.ok) {

            const errorMessage = await response.text();

            throw new Error(
                errorMessage || "Unable to load invoice."
            );
        }

        return await response.json();

    } catch (error) {

        console.error(
            "Error loading invoice:",
            error
        );

        throw error;
    }
}