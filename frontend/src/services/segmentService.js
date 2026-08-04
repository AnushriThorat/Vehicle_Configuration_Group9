const BASE_URL = `${import.meta.env.VITE_API_BASE_URL}/api`;

/**
 * Fetch all segments
 * GET /api/getSegment
 */
export const getAllSegments = async () => {
    const token = sessionStorage.getItem("token");

    try {
        const response = await fetch(`${BASE_URL}/getSegment`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${token}`,
            },
        });

        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(errorMessage || "Failed to fetch segments");
        }

        return await response.json();
    } catch (error) {
        console.error("Error fetching segments:", error);
        throw error;
    }
};