const API_URL = `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/vehicle`;

// ========================================
// GET ALL VEHICLE DETAILS
// ========================================

export async function getVehicleDetails(modelId) {

    const token = sessionStorage.getItem("token");

    try {

        const response = await fetch(
            `${API_URL}/model/${modelId}`,
            {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${token}`,
                    "Content-Type": "application/json"
                }
            }
        );

        if (!response.ok) {

            const errorMessage = await response.text();

            throw new Error(
                errorMessage || "Unable to load vehicle details"
            );

        }

        return await response.json();

    }
    catch (error) {

        console.error("Error loading vehicle details:", error);

        throw error;

    }

}

// ========================================
// GET CONFIGURABLE COMPONENTS
// ========================================

export async function getConfigurableVehicleDetails(modelId) {

    const token = sessionStorage.getItem("token");

    try {

        const response = await fetch(
            `${API_URL}/configurable/${modelId}`,
            {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${token}`,
                    "Content-Type": "application/json"
                }
            }
        );

        if (!response.ok) {

            const errorMessage = await response.text();

            throw new Error(
                errorMessage || "Unable to load configurable vehicle details"
            );

        }

        return await response.json();

    }
    catch (error) {

        console.error(
            "Error loading configurable vehicle details:",
            error
        );

        throw error;

    }

}