const BASE_URL = `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/segment`;

/**
 * GET ALL SEGMENTS
 * GET /api/segment
 */
export const getAllSegments = async () => {
    const token = sessionStorage.getItem("token");

    const response = await fetch(BASE_URL, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
        },
    });

    if (!response.ok) {
        const errorMessage = await response.text();
        throw new Error(errorMessage || "Failed to fetch segments");
    }

    return await response.json();
};