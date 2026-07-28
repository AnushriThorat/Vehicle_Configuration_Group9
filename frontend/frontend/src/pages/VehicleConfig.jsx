import { useMemo, useState } from "react";
import { toast } from "react-toastify";
import Header from "../components/Header";
import Footer from "../components/Footer";
import FormField from "../components/FormField";
import { validateRequired } from "../utils/validate";
import "./VehicleConfig.css";

// Demo taxonomy — swap for a call to your Spring Boot catalog endpoint,
// e.g. GET /api/catalog/segments, /api/catalog/manufacturers?segment=...
const SEGMENTS = ["Hatchback", "Sedan", "SUV", "Sports", "Electric"];

const MANUFACTURERS_BY_SEGMENT = {
  Hatchback: ["Maruti Suzuki", "Hyundai", "Tata"],
  Sedan: ["Honda", "Skoda", "Toyota"],
  SUV: ["Mahindra", "Kia", "MG"],
  Sports: ["Alfa Romeo", "BMW", "Porsche"],
  Electric: ["Tata", "MG", "Tesla"],
};

const MODELS_BY_MANUFACTURER = {
  "Maruti Suzuki": ["Swift", "Baleno", "WagonR"],
  Hyundai: ["i20", "Grand i10 Nios"],
  Tata: ["Tiago", "Nexon", "Punch"],
  Honda: ["City", "Amaze"],
  Skoda: ["Slavia", "Octavia"],
  Toyota: ["Camry", "Glanza"],
  Mahindra: ["XUV700", "Scorpio-N"],
  Kia: ["Seltos", "Sonet"],
  MG: ["Hector", "Astor", "ZS EV"],
  "Alfa Romeo": ["4C", "Giulia"],
  BMW: ["3 Series", "X1"],
  Porsche: ["718 Cayman", "Macan"],
  Tesla: ["Model 3", "Model Y"],
};

const REQUIRED_FIELDS = ["segment", "manufacturer", "model", "year"];
const LABELS = {
  segment: "Segment",
  manufacturer: "Manufacturer",
  model: "Model",
  year: "Year",
};

export default function VehicleConfig() {
  const [values, setValues] = useState({
    segment: "",
    manufacturer: "",
    model: "",
    year: "",
  });
  const [errors, setErrors] = useState({});

  const manufacturerOptions = useMemo(
    () => (values.segment ? MANUFACTURERS_BY_SEGMENT[values.segment] || [] : []),
    [values.segment]
  );

  const modelOptions = useMemo(
    () => (values.manufacturer ? MODELS_BY_MANUFACTURER[values.manufacturer] || [] : []),
    [values.manufacturer]
  );

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues((prev) => {
      const next = { ...prev, [name]: value };
      // Reset dependent fields when an upstream selection changes.
      if (name === "segment") {
        next.manufacturer = "";
        next.model = "";
      }
      if (name === "manufacturer") {
        next.model = "";
      }
      return next;
    });
    setErrors((prev) => ({ ...prev, [name]: undefined }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const requiredErrors = validateRequired(values, REQUIRED_FIELDS, LABELS);
    if (Object.keys(requiredErrors).length > 0) {
      setErrors(requiredErrors);
      return;
    }

    // TODO: replace with a real call to the Spring Boot listing endpoint, e.g.
    // await fetch("/api/vehicles/configure", { method: "POST", body: JSON.stringify(values) });
    toast.success(`Configuration saved: ${values.year} ${values.manufacturer} ${values.model}`);
  };

  return (
    <div className="page-shell">
      <Header isAuthenticated={true} />

      <main className="config-page">
        <div className="container">
          <div className="config-header">
            <span className="auth-eyebrow">Vehicle setup</span>
            <h1 className="config-title">Configure a vehicle</h1>
            <p className="config-subtitle">
              Pick a segment, then narrow down to the exact manufacturer and model.
            </p>
          </div>

          <form className="config-card" onSubmit={handleSubmit} noValidate>
            <div className="config-steps">
              <div className={`step-pill ${values.segment ? "step-pill--done" : ""}`}>1. Segment</div>
              <div className={`step-pill ${values.manufacturer ? "step-pill--done" : ""}`}>
                2. Manufacturer
              </div>
              <div className={`step-pill ${values.model ? "step-pill--done" : ""}`}>3. Model</div>
            </div>

            <div className="form-grid">
              <FormField
                label="Segment"
                name="segment"
                as="select"
                options={SEGMENTS}
                value={values.segment}
                onChange={handleChange}
                error={errors.segment}
              />
              <FormField
                label="Manufacturer"
                name="manufacturer"
                as="select"
                options={manufacturerOptions}
                value={values.manufacturer}
                onChange={handleChange}
                error={errors.manufacturer}
              />
              <FormField
                label="Model"
                name="model"
                as="select"
                options={modelOptions}
                value={values.model}
                onChange={handleChange}
                error={errors.model}
              />
              <FormField
                label="Year"
                name="year"
                type="number"
                value={values.year}
                onChange={handleChange}
                error={errors.year}
                placeholder="2024"
              />
            </div>

            <button type="submit" className="auth-submit config-submit">
              Save configuration
            </button>
          </form>
        </div>
      </main>

      <Footer />
    </div>
  );
}
