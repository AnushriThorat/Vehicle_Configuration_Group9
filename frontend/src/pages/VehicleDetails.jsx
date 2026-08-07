import { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";

import Header from "../components/Header";
import Footer from "../components/Footer";

import { getVehicleDetails } from "../services/vehicleDetailService";

import "./VehicleDetails.css";

const VehicleDetails = () => {

  const navigate = useNavigate();
  const location = useLocation();

  const { modelId, quantity, minimumQuantity } = location.state;

  const [vehicle, setVehicle] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    loadVehicle();
  }, []);

  const loadVehicle = async () => {

    try {

      const data = await getVehicleDetails(modelId);

      console.log("Vehicle Data:", data);
      console.log("Image Path:", data.imagePath);

      setVehicle(data);

    } catch (err) {

      console.error(err);

      setError("Unable to load vehicle details.");

    } finally {

      setLoading(false);

    }

  };

  if (loading) {
    return <h2>Loading...</h2>;
  }

  if (error) {
    return <h2>{error}</h2>;
  }

  const totalPrice =
    parseFloat(vehicle.basePrice) * Number(quantity);

  return (

    <div className="page-shell">

      <Header isAuthenticated={true} />

      <main className="vehicle-details-page">

        <div className="vehicle-details-card">

          <div className="vehicle-top">

            <div className="image-section">

              <img
                src={`/${vehicle.imagePath}`}
                alt={vehicle.modelName}
                className="vehicle-image"
                onError={(e) => {
                  console.log("Original image failed:", e.target.src);
                }}
              />

            </div>

            <div className="info-section">

              <h2>{vehicle.modelName}</h2>

              <p>
                <strong>Base Price :</strong>{" "}
                ₹ {parseFloat(vehicle.basePrice).toLocaleString("en-IN")}
              </p>

              <p>
                <strong>Minimum Quantity :</strong>{" "}
                {minimumQuantity}
              </p>

              <p>
                <strong>Selected Quantity :</strong>{" "}
                {quantity}
              </p>

              <h2 className="total-price">
                ₹ {totalPrice.toLocaleString("en-IN")}
              </h2>

            </div>

          </div>

          <div className="component-grid">

            <div className="component-card">

              <h3>Core Components</h3>

              <ul>

                {vehicle.coreComponents.map((comp) => (

                  <li key={comp.compId}>
                    {comp.compName}
                  </li>

                ))}

              </ul>

            </div>

            <div className="component-card">

              <h3>Interior Components</h3>

              <ul>

                {vehicle.interiorComponents.map((comp) => (

                  <li key={comp.compId}>
                    {comp.compName}
                  </li>

                ))}

              </ul>

            </div>

            <div className="component-card">

              <h3>Exterior Components</h3>

              <ul>

                {vehicle.exteriorComponents.map((comp) => (

                  <li key={comp.compId}>
                    {comp.compName}
                  </li>

                ))}

              </ul>

            </div>

            <div className="component-card">

              <h3>Standard Components</h3>

              <ul>

                {vehicle.standardComponents.map((comp) => (

                  <li key={comp.compId}>
                    {comp.compName}
                  </li>

                ))}

              </ul>

            </div>

          </div>

          <div className="button-group">

            <button
              className="btn confirm"
              onClick={() =>
                navigate("/invoice", {
                  state: {
                    vehicle,
                    quantity,
                    minimumQuantity,
                    selectedComponents: {},
                    additionalPrice: 0,
                    grandTotal: totalPrice
                  }
                })
              }
            >
              Confirm Order
            </button>

            <button
              className="btn configure"
              onClick={() => {

    console.log("Vehicle Before Configure:", vehicle);

    navigate("/configure", {
        state: {
            vehicle,
            quantity,
            minimumQuantity
        }
    });

}}
            >
              Configure
            </button>

            <button
              className="btn modify"
              onClick={() =>
                navigate("/configure-vehicle")
              }
            >
              Modify
            </button>

          </div>

        </div>

      </main>

      <Footer />

    </div>

  );

};

export default VehicleDetails;