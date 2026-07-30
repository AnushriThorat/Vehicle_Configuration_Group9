export function logout() {

    localStorage.removeItem("token");
    localStorage.removeItem("username");

    window.location.href = "/login";
}

export function isAuthenticated() {

    return Boolean(localStorage.getItem("token"));
}

export function getToken() {

    return localStorage.getItem("token");
}

export function getUsername() {

    return localStorage.getItem("username");
}