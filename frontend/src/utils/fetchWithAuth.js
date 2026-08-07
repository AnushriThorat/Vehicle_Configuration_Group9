const BASE_URL = "http://localhost:8080";

export async function fetchWithAuth(url, options = {}) {

    const token = localStorage.getItem("token");

    const response = await fetch(BASE_URL + url, {

        ...options,

        headers: {

            "Content-Type": "application/json",

            Authorization: `Bearer ${token}`,

            ...(options.headers || {})

        }

    });

    return response;
}