const BASE_URL = import.meta.env.VITE_DOTNET_BACKEND_URL;

/**
 * Fetch manufacturers by Segment Id
 * GET /api/mfg/segment/{segmentId}
 */
export const getManufacturersBySegment = async (segmentId) => {
    const token = sessionStorage.getItem("token");

    try {
        const response = await fetch(
            `${BASE_URL}/api/mfg/segment/${segmentId}`,
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
            throw new Error(errorMessage || "Failed to fetch manufacturers");
        }

        return await response.json();
    } catch (error) {
        console.error("Error fetching manufacturers:", error);
        throw error;
    }
};