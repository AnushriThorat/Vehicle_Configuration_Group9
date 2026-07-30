import { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

import Header from "../components/Header";
import Footer from "../components/Footer";
import FormField from "../components/FormField";
import { validateRequired } from "../utils/validate";

import "../styles/auth.css";

const REQUIRED_FIELDS = ["username", "password"];

const LABELS = {
  username: "Username",
  password: "Password",
};

export default function Login({ onLoginSuccess }) {
  const navigate = useNavigate();
  const location = useLocation();

  const redirectTo = location.state?.from || "/configure-vehicle";

  const [values, setValues] = useState({
    username: "",
    password: "",
  });

  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);

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
      LABELS
    );

    if (Object.keys(requiredErrors).length > 0) {
      setErrors(requiredErrors);
      return;
    }

    try {
      setLoading(true);

      const response = await fetch(
        "http://localhost:8080/api/auth/login",
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

        toast.error(message || "Invalid Username or Password");

        return;
      }

      const data = await response.json();

      if (!data.token) {
        toast.error("JWT token not received from server.");
        return;
      }

      sessionStorage.setItem("token", data.token);
      sessionStorage.setItem("username", data.username);

      toast.success("Login Successful");

      if (onLoginSuccess) {
        onLoginSuccess();
      }

      navigate(redirectTo, { replace: true });

      // Refresh App so authentication state is updated
      window.location.reload();

    } catch (error) {
      console.error(error);
      toast.error("Unable to connect to server.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="page-shell">
      <Header isAuthenticated={false} />

      <main className="auth-page">
        <div className="auth-card">

          <div className="auth-eyebrow">
            Welcome Back
          </div>

          <h1 className="auth-title">
            Log in to AutoDeal
          </h1>

          <p className="auth-subtitle">
            Enter your credentials to manage your dealership.
          </p>

          <form
            className="auth-form"
            onSubmit={handleSubmit}
            noValidate
          >

            <FormField
              label="Username"
              name="username"
              type="text"
              value={values.username}
              onChange={handleChange}
              error={errors.username}
              placeholder="Enter Username"
            />

            <FormField
              label="Password"
              name="password"
              type="password"
              value={values.password}
              onChange={handleChange}
              error={errors.password}
              placeholder="••••••••"
            />

            <button
              type="submit"
              className="auth-submit"
              disabled={loading}
            >
              {loading ? "Logging In..." : "Log In"}
            </button>

          </form>

          <p className="auth-footnote">
            Don't have a company account?{" "}
            <Link to="/register">
              Register here
            </Link>
          </p>

        </div>
      </main>

      <Footer />
    </div>
  );
}