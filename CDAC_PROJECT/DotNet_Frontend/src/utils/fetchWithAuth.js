const BASE_URL = import.meta.env.VITE_DOTNET_BACKEND_URL;

export async function fetchWithAuth(url, options = {}) {
    const token = sessionStorage.getItem("token");

    const response = await fetch(`${BASE_URL}${url}`, {
        ...options,
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
            ...(options.headers || {})
        }
    });

    return response;
}