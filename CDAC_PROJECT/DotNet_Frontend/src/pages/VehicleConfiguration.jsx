import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import "./VehicleConfiguration.css";

import { getAllSegments } from "../services/segmentService";
import { getManufacturersBySegment } from "../services/manufacturerService";
import { getModelsByManufacturer } from "../services/modelService";
import Header from "../components/Header";
import Footer from "../components/Footer";

const VehicleConfiguration = () => {
  const navigate = useNavigate();
  const [segments, setSegments] = useState([]);
  const [manufacturers, setManufacturers] = useState([]);
  const [models, setModels] = useState([]);

  const [selectedSegment, setSelectedSegment] = useState("");
  const [selectedManufacturer, setSelectedManufacturer] = useState("");
  const [selectedModel, setSelectedModel] = useState("");

  const [minimumQuantity, setMinimumQuantity] = useState("");

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const [quantity, setQuantity] = useState("");

  useEffect(() => {
    loadSegments();
  }, []);

  const loadSegments = async () => {
    try {
      setLoading(true);
      setError("");

      const data = await getAllSegments();
      setSegments(data);
    } catch (err) {
      console.error(err);
      setError("Unable to load segments.");
    } finally {
      setLoading(false);
    }
  };

  const handleSegmentChange = async (event) => {
    const segmentId = event.target.value;

    setSelectedSegment(segmentId);

    // Reset dependent fields
    setSelectedManufacturer("");
    setSelectedModel("");

    setManufacturers([]);
    setModels([]);

    if (!segmentId) {
      setMinimumQuantity("");
      return;
    }

    const selected = segments.find(
      (segment) => segment.segId === Number(segmentId),
    );

    console.log("Selected Segment:", selected);

    if (selected) {
      setMinimumQuantity(selected.minQty);
    }

    try {
      setLoading(true);

      const data = await getManufacturersBySegment(segmentId);
      console.log("Manufacturers:", data);
      setManufacturers(data);
    } catch (err) {
      console.error(err);
      setError("Unable to load manufacturers.");
    } finally {
      setLoading(false);
    }
  };

  const handleManufacturerChange = async (event) => {
    const manufacturerId = event.target.value;

    setSelectedManufacturer(manufacturerId);

    setSelectedModel("");
    setModels([]);

    if (!manufacturerId) {
      return;
    }

    try {
      setLoading(true);

      const data = await getModelsByManufacturer(manufacturerId);
      console.log("Models:", data);
      setModels(data);
    } catch (err) {
      console.error(err);
      setError("Unable to load models.");
    } finally {
      setLoading(false);
    }
  };

  const handleModelChange = (event) => {
    setSelectedModel(event.target.value);
  };

  const handleContinue = () => {
    if (!selectedSegment) {
      alert("Please select a segment.");
      return;
    }

    if (!selectedManufacturer) {
      alert("Please select a manufacturer.");
      return;
    }

    if (!selectedModel) {
      alert("Please select a model.");
      return;
    }

    if (!quantity) {
      alert("Please enter quantity.");
      return;
    }

    if (Number(quantity) < minimumQuantity) {
      alert(`Minimum quantity is ${minimumQuantity}`);
      return;
    }

    navigate("/vehicle-details", {
      state: {
        segmentId: selectedSegment,
        manufacturerId: selectedManufacturer,
        modelId: selectedModel,
        quantity: Number(quantity),
        minimumQuantity: minimumQuantity,
      },
    });
  };

  return (
  <div className="page-shell">

    <Header isAuthenticated={true} />

    <main className="vehicle-config-page">
      <div className="vehicle-config-card">

        <div className="vehicle-config-header">
          <h2>Vehicle Configuration</h2>
          <p>Select Segment, Manufacturer and Model</p>
        </div>

        <div className="vehicle-config-form">

          {loading && (
            <div className="message">
              Loading...
            </div>
          )}

          {error && (
            <div className="message">
              {error}
            </div>
          )}

          <label>Select Segment</label>

          <select
            value={selectedSegment}
            onChange={handleSegmentChange}
          >
            <option value="">-- Select Segment --</option>

            {segments.map((segment) => (
              <option
                key={segment.segId}
                value={segment.segId}
              >
                {segment.segName}
              </option>
            ))}
          </select>

          <label>Select Manufacturer</label>

          <select
            value={selectedManufacturer}
            onChange={handleManufacturerChange}
            disabled={!selectedSegment}
          >
            <option value="">-- Select Manufacturer --</option>

            {manufacturers.map((manufacturer) => (
              <option
                key={manufacturer.mfgId}
                value={manufacturer.mfgId}
              >
                {manufacturer.mfgName}
              </option>
            ))}
          </select>

          <label>Select Model</label>

          <select
            value={selectedModel}
            onChange={handleModelChange}
            disabled={!selectedManufacturer}
          >
            <option value="">-- Select Model --</option>

            {models.map((model) => (
              <option
                key={model.modelId}
                value={model.modelId}
              >
                {model.modelName}
              </option>
            ))}
          </select>

          <div className="form-group">
            <label>Quantity</label>

            <input
              type="number"
              min={minimumQuantity}
              value={quantity}
              onChange={(e) => setQuantity(e.target.value)}
              placeholder={`Minimum Quantity: ${minimumQuantity}`}
            />

            {quantity &&
              Number(quantity) < minimumQuantity && (
                <p className="error">
                  Minimum quantity for this segment is {minimumQuantity}.
                </p>
              )}
          </div>

          <button
  className="continue-btn"
  onClick={handleContinue}
  disabled={
    !selectedSegment ||
    !selectedManufacturer ||
    !selectedModel ||
    !quantity ||
    Number(quantity) < minimumQuantity
  }
>
  Continue →
</button>
        </div>

      </div>
    </main>

    <Footer />

  </div>
);
};

export default VehicleConfiguration;