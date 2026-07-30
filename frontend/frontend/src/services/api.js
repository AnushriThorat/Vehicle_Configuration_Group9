const BASE_URL = "http://localhost:8080";


export const apiFetch = async (url, options = {}) => {

    const token = localStorage.getItem("authToken");


    const response = await fetch(
        `${BASE_URL}${url}`,
        {
            ...options,

            headers: {
                "Content-Type": "application/json",

                ...(token && {
                    Authorization: `Bearer ${token}`
                }),

                ...options.headers
            }
        }
    );


    return response;

};