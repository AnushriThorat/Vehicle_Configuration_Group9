import { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";

import Header from "../components/Header";
import Footer from "../components/Footer";

import ConfigurationSection from "../components/ConfigurationSection";
import PriceSummary from "../components/PriceSummary";

import { getAdditionalComponents } from "../services/additionalComponentService";
import { getConfigurableVehicleDetails } from "../services/vehicleDetailService";

import "./Configure.css";

const Configure = () => {

    const navigate = useNavigate();

    const location = useLocation();

    const { vehicle, quantity, minimumQuantity } = location.state;

    const [configurableVehicle, setConfigurableVehicle] = useState(null);

    const [additionalComponents, setAdditionalComponents] = useState([]);

    const [selectedComponents, setSelectedComponents] = useState({});

    const [activeTab, setActiveTab] = useState("INTERIOR");

    const [loading, setLoading] = useState(true);

    const [error, setError] = useState("");

    useEffect(() => {

        loadConfigurationData();

    }, []);

    const loadConfigurationData = async () => {

        try {

            const [vehicleData, componentData] = await Promise.all([

                getConfigurableVehicleDetails(vehicle.modelId),

                getAdditionalComponents(vehicle.modelId)

            ]);

            setConfigurableVehicle(vehicleData);

            setAdditionalComponents(componentData);

        }

        catch (err) {

            console.error(err);

            setError("Unable to load configurable components.");

        }

        finally {

            setLoading(false);

        }

    };

    const handleSelection = (component) => {

        setSelectedComponents(previous => ({

            ...previous,

            [component.compId]: component

        }));

    };

    const removeSelection = (compId) => {

        const updated = { ...selectedComponents };

        delete updated[compId];

        setSelectedComponents(updated);

    };

    const getCategoryComponents = (categoryComponents) => {

        return additionalComponents.filter(additional =>

            categoryComponents.some(component =>

                component.compId === additional.compId

            )

        );

    };

    const coreComponents =
        getCategoryComponents(configurableVehicle?.coreComponents || []);

    const standardComponents =
        getCategoryComponents(configurableVehicle?.standardComponents || []);

    const interiorComponents =
        getCategoryComponents(configurableVehicle?.interiorComponents || []);

    const exteriorComponents =
        getCategoryComponents(configurableVehicle?.exteriorComponents || []);

    const additionalPrice =
        Object.values(selectedComponents).reduce(

            (total, component) => total + component.deltaPrice,

            0

        );

    const baseTotal =
        Number(vehicle.basePrice) * Number(quantity);

    const grandTotal =
        baseTotal + (additionalPrice * Number(quantity));

    const handleConfirm = () => {

        navigate("/invoice", {

            state: {

                vehicle,

                quantity,

                minimumQuantity,

                selectedComponents,

                additionalPrice,

                grandTotal

            }

        });

    };

    if (loading)
        return <h2 className="loading-message">Loading...</h2>;

    if (error)
        return <h2 className="error-message">{error}</h2>;

        return (

        <div className="page-shell">

            <Header isAuthenticated={true} />

            <main className="configure-page">

                <div className="configure-container">

                    {/* LEFT PANEL */}

                    <div className="left-panel">

                        <div className="vehicle-image-card">

                            <img
                                src={`/${vehicle.imagePath}`}
                                alt={vehicle.modelName}
                            />

                            <div className="vehicle-overlay"></div>

                            <div className="vehicle-name">

                                <h2>{vehicle.modelName}</h2>

                                <p>

                                    Build your perfect configuration

                                </p>

                            </div>

                        </div>

                        <div className="component-tabs">

                            <button

                                className={activeTab === "I" ? "active" : ""}

                                onClick={() => setActiveTab("I")}

                            >

                                Interior

                            </button>

                            <button

                                className={activeTab === "E" ? "active" : ""}

                                onClick={() => setActiveTab("E")}

                            >

                                Exterior

                            </button>

                            <button

                                className={activeTab === "S" ? "active" : ""}

                                onClick={() => setActiveTab("S")}

                            >

                                Standard

                            </button>

                            <button

                                className={activeTab === "C" ? "active" : ""}

                                onClick={() => setActiveTab("C")}

                            >

                                Core

                            </button>

                        </div>

                        <div className="component-content">

                            {activeTab === "I" && (

                                <ConfigurationSection
                                    title="Interior Components"
                                    components={interiorComponents}
                                    selectedComponents={selectedComponents}
                                    handleSelection={handleSelection}
                                    removeSelection={removeSelection}
                                />

                            )}

                            {activeTab === "E" && (

                                <ConfigurationSection
                                    title="Exterior Components"
                                    components={exteriorComponents}
                                    selectedComponents={selectedComponents}
                                    handleSelection={handleSelection}
                                    removeSelection={removeSelection}
                                />

                            )}

                            {activeTab === "S" && (

                                <ConfigurationSection
                                    title="Standard Components"
                                    components={standardComponents}
                                    selectedComponents={selectedComponents}
                                    handleSelection={handleSelection}
                                    removeSelection={removeSelection}
                                />

                            )}

                            {activeTab === "C" && (

                                <ConfigurationSection
                                    title="Core Components"
                                    components={coreComponents}
                                    selectedComponents={selectedComponents}
                                    handleSelection={handleSelection}
                                    removeSelection={removeSelection}
                                />

                            )}

                        </div>

                    </div>

                    {/* RIGHT PANEL */}

                    <div className="right-panel">

                        <PriceSummary
                            selectedComponents={selectedComponents}
                            baseTotal={baseTotal}
                            additionalPrice={additionalPrice}
                            quantity={quantity}
                            grandTotal={grandTotal}
                            onConfirm={handleConfirm}
                        />

                    </div>

                </div>

            </main>

            <Footer />

        </div>

    );

};

export default Configure;