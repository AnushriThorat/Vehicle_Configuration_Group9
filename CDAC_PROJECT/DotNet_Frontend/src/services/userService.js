const API_URL =
    `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/users`;

// =====================================================
// GET USER BY ID
// GET /api/users/{id}
// =====================================================

export async function getUser(id) {

    const token = sessionStorage.getItem("token");

    if (!id) {
        throw new Error("User ID is required.");
    }

    try {

        const response = await fetch(
            `${API_URL}/${id}`,
            {
                method: "GET",

                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${token}`
                }
            }
        );

        if (!response.ok) {

            const errorMessage =
                await response.text();

            throw new Error(
                errorMessage ||
                "Unable to load user."
            );
        }

        return await response.json();

    } catch (error) {

        console.error(
            "Error loading user:",
            error
        );

        throw error;
    }
}