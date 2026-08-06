const BASE_URL = "http://localhost:8080";

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