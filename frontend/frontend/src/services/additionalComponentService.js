const API_URL = "http://localhost:8080/api/additional-components";

export async function getAdditionalComponents(modelId) {

    const token = sessionStorage.getItem("token");

    const response = await fetch(`${API_URL}/model/${modelId}`, {

        method: "GET",

        headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json"
        }

    });

    if (!response.ok) {

        throw new Error("Unable to load additional components");

    }

    return await response.json();
}