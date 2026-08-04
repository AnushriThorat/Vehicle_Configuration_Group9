const BASE_URL = import.meta.env.VITE_API_BASE_URL;

export const getManufacturersBySegment = async (segmentId) => {
    const token = sessionStorage.getItem("token");

    const response = await fetch(
        `${BASE_URL}/manufacturers/segment/${segmentId}`,
        {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${token}`,
            },
        }
    );

    if (!response.ok) {
        throw new Error("Failed to fetch manufacturers");
    }

    return await response.json();
};