const BASE_URL = import.meta.env.VITE_DOTNET_BACKEND_URL;

/**
 * Fetch Models by Manufacturer
 * GET /api/model/manufacturer/{manufacturerId}
 */
export const getModelsByManufacturer = async (manufacturerId) => {
    const token = sessionStorage.getItem("token");

    try {
        const response = await fetch(
            `${BASE_URL}/api/model/manufacturer/${manufacturerId}`,
            {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    Authorization: `Bearer ${token}`,
                },
            }
        );

        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(errorMessage || "Failed to fetch models");
        }

        return await response.json();
    } catch (error) {
        console.error("Error fetching models:", error);
        throw error;
    }
};