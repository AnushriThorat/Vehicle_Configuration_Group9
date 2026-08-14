
import { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { useTranslation } from "react-i18next";
import { toast } from "react-toastify";

import Header from "../components/Header";
import Footer from "../components/Footer";
import FormField from "../components/FormField";
import { validateRequired } from "../utils/validate";
   
import "../styles/auth.css";

const REQUIRED_FIELDS = ["username", "password"];

export default function Login({ onLoginSuccess }) {
  const navigate = useNavigate();
  const location = useLocation();
  const { t } = useTranslation();

  const redirectTo =
    location.state?.from || "/configure-vehicle";

  const [values, setValues] = useState({
    username: "",
    password: "",
  });

  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);

  /*
   * Translation labels used by validation.
   * This must be inside the component because
   * t() comes from useTranslation().
   */
  const labels = {
    username: t("username"),
    password: t("password"),
  };

  const handleChange = (e) => {
    const { name, value } = e.target;

    setValues((prev) => ({
      ...prev,
      [name]: value,
    }));

    setErrors((prev) => ({
      ...prev,
      [name]: undefined,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const requiredErrors = validateRequired(
      values,
      REQUIRED_FIELDS,
      labels
    );

    if (Object.keys(requiredErrors).length > 0) {
      setErrors(requiredErrors);
      return;
    }

    try {
      setLoading(true);

      const response = await fetch(
        `${import.meta.env.VITE_DOTNET_BACKEND_URL}/api/auth/login`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            username: values.username,
            password: values.password,
          }),
        }
      );

      if (!response.ok) {
        const message = await response.text();

        toast.error(
          message || t("invalidCredentials")
        );

        return;
      }

      const data = await response.json();

      if (!data.token) {
        toast.error(t("jwtTokenNotReceived"));
        return;
      }

      const loggedInUserId =
    data.id ??
    data.userId ??
    data.user?.id;

if (
    loggedInUserId === null ||
    loggedInUserId === undefined ||
    loggedInUserId === ""
) {
    console.error(
        "Login response does not contain a user ID:",
        data
    );

    toast.error(
        "Login successful, but user ID was not returned by the server."
    );

    return;
}

sessionStorage.setItem(
    "token",
    data.token
);

sessionStorage.setItem(
    "username",
    data.username ?? values.username
);

sessionStorage.setItem(
    "userId",
    String(loggedInUserId)
);

console.log(
    "Logged-in User ID:",
    loggedInUserId
);
      toast.success(t("loginSuccessful"));

      if (onLoginSuccess) {
        onLoginSuccess();
      }

      navigate(redirectTo, {
        replace: true,
      });

      /*
       * Refresh App so authentication state is updated.
       */
      window.location.reload();

    } catch (error) {
      console.error(error);

      toast.error(t("unableToConnect"));

    } finally {
      setLoading(false);
    }
  };

  const handleGoogleLogin = () => {
    window.location.href =
      "http://localhost:8080/oauth2/authorization/google";
  };

  return (
    <div className="page-shell">

      <Header isAuthenticated={false} />

      <main className="auth-page">

        <div className="auth-card">

          <div className="auth-eyebrow">
            {t("loginWelcome")}
          </div>

          <h1 className="auth-title">
            {t("loginTitle")}
          </h1>

          <p className="auth-subtitle">
            {t("loginSubtitle")}
          </p>

          <form
            className="auth-form"
            onSubmit={handleSubmit}
            noValidate
          >

            <FormField
              label={t("username")}
              name="username"
              type="text"
              value={values.username}
              onChange={handleChange}
              error={errors.username}
              placeholder={t("enterUsername")}
            />

            <FormField
              label={t("password")}
              name="password"
              type="password"
              value={values.password}
              onChange={handleChange}
              error={errors.password}
              placeholder={t("loginPasswordPlaceholder")}
            />

            <button
              type="submit"
              className="auth-submit"
              disabled={loading}
            >
              {loading
                ? t("loggingIn")
                : t("login")}
            </button>

            <div className="google-login-container">

              <div className="divider">
                <span>{t("or")}</span>
              </div>

              <button
                type="button"
                className="google-login-btn"
                onClick={handleGoogleLogin}
              >

                <img
                  src="https://developers.google.com/identity/images/g-logo.png"
                  alt="Google"
                />

                {t("continueWithGoogle")}

              </button>

            </div>

          </form>

          <p className="auth-footnote">

            {t("noCompanyAccount")}{" "}

            <Link to="/register">
              {t("registerHere")}
            </Link>

          </p>

        </div>

      </main>

      <Footer />

    </div>
  );
}
