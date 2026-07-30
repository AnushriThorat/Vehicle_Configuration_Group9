import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

import Header from "../components/Header";
import Footer from "../components/Footer";
import FormField from "../components/FormField";

import { validateRequired } from "../utils/validate";

import "../styles/auth.css";

const COMPANY_TYPES = [
  "Private",
  "Public",
  "Partnership",
  "LLP",
  "Proprietorship"
];

const INITIAL_VALUES = {

  username: "",
  password: "",

  companyName: "",
  companyEmail: "",
  registrationNo: "",
  holdingType: "",

  address1: "",
  address2: "",

  city: "",
  state: "",
  pin: "",

  authorizedPersonName: "",
  designation: "",
  authPersonTel: "",

  cell: "",
  phone: "",
  fax: "",

  companyStNo: "",
  companyVatNo: "",
  taxPan: ""

};

const REQUIRED_FIELDS = [

  "username",
  "password",

  "companyName",
  "companyEmail",
  "registrationNo",
  "holdingType",

  "address1",

  "city",
  "state",
  "pin",

  "authorizedPersonName",
  "designation",

  "cell"

];

const LABELS = {

  username: "Username",
  password: "Password",

  companyName: "Company Name",
  companyEmail: "Company Email",
  registrationNo: "Registration Number",
  holdingType: "Holding Type",

  address1: "Address Line 1",

  city: "City",
  state: "State",
  pin: "PIN Code",

  authorizedPersonName: "Authorized Person",
  designation: "Designation",

  cell: "Mobile"

};

export default function Registration() {

  const navigate = useNavigate();

  const [values, setValues] = useState(INITIAL_VALUES);

  const [errors, setErrors] = useState({});

  const [loading, setLoading] = useState(false);

  const handleChange = (e) => {

    const { name, value } = e.target;

    setValues((prev) => ({

      ...prev,

      [name]: value

    }));

    setErrors((prev) => ({

      ...prev,

      [name]: undefined

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

        "http://localhost:8080/api/auth/register",

        {

          method: "POST",

          headers: {

            "Content-Type": "application/json"

          },

          body: JSON.stringify(values)

        }

      );

      const message = await response.text();

      if (!response.ok) {

        toast.error(message);

        return;

      }

      toast.success(message);

      navigate("/login");

    }

    catch (error) {

      console.error(error);

      toast.error("Unable to connect to server.");

    }

    finally {

      setLoading(false);

    }

  };
  return (
  <div className="page-shell">
    <Header isAuthenticated={false} />

    <main className="auth-page">
      <div className="auth-card auth-card--wide">

        <div className="auth-eyebrow">
          Get Started
        </div>

        <h1 className="auth-title">
          Company Registration
        </h1>

        <p className="auth-subtitle">
          Register your company to use Vehicle Configurator.
        </p>

        <form
          className="auth-form"
          onSubmit={handleSubmit}
          noValidate
        >

          <div className="form-grid">

            <FormField
              label="Username"
              name="username"
              value={values.username}
              onChange={handleChange}
              error={errors.username}
            />

            <FormField
              label="Password"
              type="password"
              name="password"
              value={values.password}
              onChange={handleChange}
              error={errors.password}
            />

            <FormField
              label="Company Name"
              name="companyName"
              value={values.companyName}
              onChange={handleChange}
              error={errors.companyName}
            />

            <FormField
              label="Company Email"
              type="email"
              name="companyEmail"
              value={values.companyEmail}
              onChange={handleChange}
              error={errors.companyEmail}
            />

            <FormField
              label="Registration Number"
              name="registrationNo"
              value={values.registrationNo}
              onChange={handleChange}
              error={errors.registrationNo}
            />

            <FormField
              label="Holding Type"
              as="select"
              name="holdingType"
              options={COMPANY_TYPES}
              value={values.holdingType}
              onChange={handleChange}
              error={errors.holdingType}
            />

            <div className="form-grid--span2">
              <FormField
                label="Address Line 1"
                name="address1"
                value={values.address1}
                onChange={handleChange}
                error={errors.address1}
              />
            </div>

            <div className="form-grid--span2">
              <FormField
                label="Address Line 2"
                name="address2"
                value={values.address2}
                onChange={handleChange}
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
              label="PIN Code"
              name="pin"
              value={values.pin}
              onChange={handleChange}
              error={errors.pin}
            />

            <FormField
              label="Authorized Person"
              name="authorizedPersonName"
              value={values.authorizedPersonName}
              onChange={handleChange}
              error={errors.authorizedPersonName}
            />

            <FormField
              label="Designation"
              name="designation"
              value={values.designation}
              onChange={handleChange}
              error={errors.designation}
            />

            <FormField
              label="Authorized Person Telephone"
              name="authPersonTel"
              value={values.authPersonTel}
              onChange={handleChange}
            />

            <FormField
              label="Mobile"
              name="cell"
              value={values.cell}
              onChange={handleChange}
              error={errors.cell}
            />

            <FormField
              label="Phone"
              name="phone"
              value={values.phone}
              onChange={handleChange}
            />

            <FormField
              label="Fax"
              name="fax"
              value={values.fax}
              onChange={handleChange}
            />

            <FormField
              label="Company ST No"
              name="companyStNo"
              value={values.companyStNo}
              onChange={handleChange}
            />

            <FormField
              label="Company VAT No"
              name="companyVatNo"
              value={values.companyVatNo}
              onChange={handleChange}
            />

            <FormField
              label="Tax PAN"
              name="taxPan"
              value={values.taxPan}
              onChange={handleChange}
            />

          </div>

          <button
            type="submit"
            className="auth-submit"
            disabled={loading}
          >
            {loading ? "Registering..." : "Register Company"}
          </button>

        </form>

        <p className="auth-footnote">
          Already have an account?{" "}
          <Link to="/login">
            Login
          </Link>
        </p>

      </div>
    </main>

    <Footer />
  </div>
);
}