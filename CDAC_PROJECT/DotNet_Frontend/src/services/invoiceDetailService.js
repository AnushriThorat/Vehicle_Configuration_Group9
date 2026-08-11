const API_URL =
    `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/invoice`;

// =====================================================
// GET INVOICE DETAILS
//
// The .NET API returns the complete invoice response:
//
// {
//     header: {...},
//     details: [...]
// }
//
// GET /api/invoice/{invoiceId}
// =====================================================

export async function getInvoiceDetails(invoiceId) {

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
                errorMessage || "Unable to load invoice details."
            );
        }

        return await response.json();

    } catch (error) {

        console.error(
            "Error loading invoice details:",
            error
        );

        throw error;
    }
}