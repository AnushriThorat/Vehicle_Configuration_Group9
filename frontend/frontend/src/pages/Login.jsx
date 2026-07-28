import { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Header from "../components/Header";
import Footer from "../components/Footer";
import FormField from "../components/FormField";
import { validateRequired, isValidEmail } from "../utils/validate";
import "../styles/auth.css";

const REQUIRED_FIELDS = ["email", "password"];
const LABELS = { email: "Email", password: "Password" };

export default function Login({ onLoginSuccess }) {
  const navigate = useNavigate();
  const location = useLocation();
  const redirectTo = location.state?.from || "/";

  const [values, setValues] = useState({ email: "", password: "" });
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues((prev) => ({ ...prev, [name]: value }));
    setErrors((prev) => ({ ...prev, [name]: undefined }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const requiredErrors = validateRequired(values, REQUIRED_FIELDS, LABELS);
    if (Object.keys(requiredErrors).length > 0) {
      setErrors(requiredErrors);
      return;
    }

    if (!isValidEmail(values.email)) {
      setErrors({ email: "Enter a valid email address" });
      toast.error("Enter a valid email address.");
      return;
    }

    // TODO: replace with a real call to the Spring Boot auth endpoint, e.g.
    // const res = await fetch("/api/auth/login", { method: "POST", ... });
    localStorage.setItem("authToken", "demo-token");
    toast.success("Logged in successfully.");
    onLoginSuccess();
    navigate(redirectTo, { replace: true });
  };

  return (
    <div className="page-shell">
      <Header isAuthenticated={false} />

      <main className="auth-page">
        <div className="auth-card">
          <div className="auth-eyebrow">Welcome back</div>
          <h1 className="auth-title">Log in to AutoDeal</h1>
          <p className="auth-subtitle">
            Enter your credentials to manage your dealership listings.
          </p>

          <form className="auth-form" onSubmit={handleSubmit} noValidate>
            <FormField
              label="Email"
              name="email"
              type="email"
              value={values.email}
              onChange={handleChange}
              error={errors.email}
              placeholder="you@company.com"
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

            <button type="submit" className="auth-submit">
              Log in
            </button>
          </form>

          <p className="auth-footnote">
            Don&apos;t have a company account? <Link to="/register">Register here</Link>
          </p>
        </div>
      </main>

      <Footer />
    </div>
  );
}
