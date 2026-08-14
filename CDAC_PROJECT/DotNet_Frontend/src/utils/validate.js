import { toast } from "react-toastify";

/**
 * Validates that every field listed in `requiredFields` has a non-empty
 * value in `values`. Returns an { [field]: message } error map and fires a
 * single toast telling the user which fields are mandatory.
 */
export function validateRequired(values, requiredFields, labels = {}) {
  const errors = {};

  requiredFields.forEach((field) => {
    const value = values[field];
    if (value === undefined || value === null || String(value).trim() === "") {
      errors[field] = "This field is mandatory";
    }
  });

  const missing = Object.keys(errors);
  if (missing.length > 0) {
    const names = missing.map((f) => labels[f] || f).join(", ");
    toast.error(
      missing.length === 1
        ? `${names} is mandatory.`
        : `Please fill the mandatory fields: ${names}.`
    );
  }

  return errors;
}

export function isValidEmail(email) {
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

export function isValidPhone(phone) {
  return /^\d{10}$/.test(phone);
}
