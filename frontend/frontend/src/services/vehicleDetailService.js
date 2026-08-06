const API_URL = "http://localhost:8080/api/vehicle-details";

// ========================================
// GET ALL VEHICLE DETAILS
// Used in Vehicle Details Page
// ========================================

export async function getVehicleDetails(modelId) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(`${API_URL}/model/${modelId}`, {

        method: "GET",

        headers: {

            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json"

        }

    });

    if (!response.ok) {

        throw new Error("Unable to load vehicle details");

    }

    return await response.json();

}

// ========================================
// GET ONLY CONFIGURABLE COMPONENTS
// Used in Configure Page
// ========================================

export async function getConfigurableVehicleDetails(modelId) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(
        `${API_URL}/model/${modelId}/configurable`,
        {

            method: "GET",

            headers: {

                Authorization: `Bearer ${token}`,
                "Content-Type": "application/json"

            }

        }
    );

    if (!response.ok) {

        throw new Error("Unable to load configurable vehicle details");

    }

    return await response.json();

}