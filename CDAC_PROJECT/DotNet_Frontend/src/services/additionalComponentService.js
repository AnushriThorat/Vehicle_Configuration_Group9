const API_URL =
    `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/alternate-component`;

/**
 * Get alternate components for a model
 *
 * GET /api/alternate-component/model/{modelId}
 */
export async function getAdditionalComponents(modelId) {
    const token = sessionStorage.getItem("token");

    try {
        const response = await fetch(
            `${API_URL}/model/${modelId}`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    Authorization: `Bearer ${token}`
                }
            }
        );

        if (!response.ok) {
            const errorMessage = await response.text();

            throw new Error(
                errorMessage ||
                "Unable to load additional components"
            );
        }

        const data = await response.json();

        console.log(
            "Additional Components:",
            data
        );

        return data;

    } catch (error) {
        console.error(
            "Error fetching additional components:",
            error
        );

        throw error;
    }
}