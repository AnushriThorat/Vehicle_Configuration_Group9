import api from "./api";

const authApi = {
  login: (credentials) => {
    return api.post("api/auth/login", credentials);
  },

  register: (user) => {
    return api.post("api/auth/register", user);
  },

  logout: () => {
    return api.post("api/auth/logout");
  },
};

export default authApi;