import "./FormField.css";

export default function FormField({
  label,
  name,
  type = "text",
  value,
  onChange,
  error,
  placeholder,
  as = "input",
  options = [],
  required = true,
}) {
  return (
    <div className={`form-field ${error ? "form-field--error" : ""}`}>
      <label htmlFor={name}>
        {label}
        {required && <span className="required-mark">*</span>}
      </label>

      {as === "select" ? (
        <select id={name} name={name} value={value} onChange={onChange}>
          <option value="">Select {label.toLowerCase()}</option>
          {options.map((opt) => (
            <option key={opt} value={opt}>
              {opt}
            </option>
          ))}
        </select>
      ) : (
        <input
          id={name}
          name={name}
          type={type}
          value={value}
          onChange={onChange}
          placeholder={placeholder}
          autoComplete="off"
        />
      )}

      {error && <span className="field-error">{error}</span>}
    </div>
  );
}
