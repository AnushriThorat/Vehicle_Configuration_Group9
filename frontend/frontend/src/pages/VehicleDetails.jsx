import { useLocation } from "react-router-dom";

function VehicleDetails() {

    const { state } = useLocation();

    console.log(state);

    return (
        <div>

            <h2>Vehicle Details</h2>

            <p>Segment : {state.segmentId}</p>
            <p>Manufacturer : {state.manufacturerId}</p>
            <p>Model : {state.modelId}</p>
            <p>Quantity : {state.quantity}</p>

        </div>
    );
}

export default VehicleDetails;