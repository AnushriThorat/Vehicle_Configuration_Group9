const API_URL = `${import.meta.env.VITE_API_BASE_URL}/api/users`;

export async function getUser(id) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(`${API_URL}/${id}`, {

        headers: {

            Authorization: `Bearer ${token}`,

            "Content-Type": "application/json"

        }

    });

    if (!response.ok) {

        throw new Error("Unable to load user.");

    }

    return await response.json();

}