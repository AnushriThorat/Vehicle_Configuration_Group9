import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Header from "../components/Header";
import Footer from "../components/Footer";
import FormField from "../components/FormField";
import { validateRequired, isValidEmail, isValidPhone } from "../utils/validate";
import "../styles/auth.css";

const COMPANY_TYPES = ["Rental Company", "Fleet Partner", "Finance Partner", "Individual"];

const INITIAL_VALUES = {
  companyName: "",
  companyType: "",
  gstNumber: "",
  contactPerson: "",
  email: "",
  phone: "",
  addressLine1: "",
  city: "",
  state: "",
  pincode: "",
  password: "",
  confirmPassword: "",
};

const REQUIRED_FIELDS = [
  "companyName",
  "companyType",
  "gstNumber",
  "contactPerson",
  "email",
  "phone",
  "addressLine1",
  "city",
  "state",
  "pincode",
  "password",
  "confirmPassword",
];

const LABELS = {
  companyName: "Company name",
  companyType: "Company type",
  gstNumber: "GST / registration number",
  contactPerson: "Contact person",
  email: "Email",
  phone: "Phone",
  addressLine1: "Address",
  city: "City",
  state: "State",
  pincode: "Pincode",
  password: "Password",
  confirmPassword: "Confirm password",
};

export default function Registration() {
  const navigate = useNavigate();
  const [values, setValues] = useState(INITIAL_VALUES);
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues((prev) => ({ ...prev, [name]: value }));
    setErrors((prev) => ({ ...prev, [name]: undefined }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const requiredErrors = validateRequired(values, REQUIRED_FIELDS, LABELS);

    if (values.email && !isValidEmail(values.email)) {
      requiredErrors.email = "Enter a valid email address";
    }
    if (values.phone && !isValidPhone(values.phone)) {
      requiredErrors.phone = "Enter a valid 10-digit phone number";
    }
    if (
      values.password &&
      values.confirmPassword &&
      values.password !== values.confirmPassword
    ) {
      requiredErrors.confirmPassword = "Passwords do not match";
      toast.error("Passwords do not match.");
    }

    if (Object.keys(requiredErrors).length > 0) {
      setErrors(requiredErrors);
      return;
    }

    // TODO: replace with a real call to the Spring Boot registration endpoint, e.g.
    // await fetch("/api/companies/register", { method: "POST", body: JSON.stringify(values) });
    toast.success("Company registered successfully. Please log in.");
    navigate("/login");
  };

  return (
    <div className="page-shell">
      <Header isAuthenticated={false} />

      <main className="auth-page">
        <div className="auth-card auth-card--wide">
          <div className="auth-eyebrow">Get listed</div>
          <h1 className="auth-title">Register your company</h1>
          <p className="auth-subtitle">
            Fields marked <span style={{ color: "var(--accent-blue)" }}>*</span> are
            mandatory.
          </p>

          <form className="auth-form" onSubmit={handleSubmit} noValidate>
            <div className="form-grid">
              <FormField
                label="Company name"
                name="companyName"
                value={values.companyName}
                onChange={handleChange}
                error={errors.companyName}
                placeholder="Wardrobe Motors Pvt. Ltd."
              />
              <FormField
                label="Company type"
                name="companyType"
                as="select"
                options={COMPANY_TYPES}
                value={values.companyType}
                onChange={handleChange}
                error={errors.companyType}
              />
              <FormField
                label="GST / registration number"
                name="gstNumber"
                value={values.gstNumber}
                onChange={handleChange}
                error={errors.gstNumber}
                placeholder="22AAAAA0000A1Z5"
              />
              <FormField
                label="Contact person"
                name="contactPerson"
                value={values.contactPerson}
                onChange={handleChange}
                error={errors.contactPerson}
                placeholder="Full name"
              />
              <FormField
                label="Email"
                name="email"
                type="email"
                value={values.email}
                onChange={handleChange}
                error={errors.email}
                placeholder="company@email.com"
              />
              <FormField
                label="Phone"
                name="phone"
                type="tel"
                value={values.phone}
                onChange={handleChange}
                error={errors.phone}
                placeholder="10-digit number"
              />
              <div className="form-grid--span2">
                <FormField
                  label="Address"
                  name="addressLine1"
                  value={values.addressLine1}
                  onChange={handleChange}
                  error={errors.addressLine1}
                  placeholder="Street, area"
                />
              </div>
              <FormField
                label="City"
                name="city"
                value={values.city}
                onChange={handleChange}
                error={errors.city}
              />
              <FormField
                label="State"
                name="state"
                value={values.state}
                onChange={handleChange}
                error={errors.state}
              />
              <FormField
                label="Pincode"
                name="pincode"
                value={values.pincode}
                onChange={handleChange}
                error={errors.pincode}
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
              <FormField
                label="Confirm password"
                name="confirmPassword"
                type="password"
                value={values.confirmPassword}
                onChange={handleChange}
                error={errors.confirmPassword}
                placeholder="••••••••"
              />
            </div>

            <button type="submit" className="auth-submit">
              Register company
            </button>
          </form>

          <p className="auth-footnote">
            Already registered? <Link to="/login">Log in</Link>
          </p>
        </div>
      </main>

      <Footer />
    </div>
  );
}
