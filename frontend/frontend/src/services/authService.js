import authApi from "../api/authApi";
import {
  saveToken,
  removeToken,
  getToken,
} from "../utils/tokenStorage";

const authService = {
  async login(username, password) {
    const response = await authApi.login({
      username,
      password,
    });

    const token = response.data.token;

    saveToken(token);

    return response.data;
  },

  logout() {
    removeToken();
  },

  getToken() {
    return getToken();
  },

  isAuthenticated() {
    return !!getToken();
  },
};

export default authService;