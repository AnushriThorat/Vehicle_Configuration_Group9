const BASE_URL = import.meta.env.VITE_API_BASE_URL;

export const getModelsByManufacturer = async (manufacturerId) => {
    const token = sessionStorage.getItem("token");

    const response = await fetch(
        `${BASE_URL}/models/manufacturer/${manufacturerId}`,
        {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
            },
        }
    );

    if (!response.ok) {
        throw new Error("Failed to fetch models");
    }

    return await response.json();
};