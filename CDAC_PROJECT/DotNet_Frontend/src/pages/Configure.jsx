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

    const {
        vehicle,
        quantity,
        minimumQuantity
    } = location.state || {};

    const [configurableVehicle, setConfigurableVehicle] = useState([]);

    const [additionalComponents, setAdditionalComponents] = useState([]);

    const [selectedComponents, setSelectedComponents] = useState({});

    // IMPORTANT:
    // Use "I" because the tab buttons below use I/E/S/C
    const [activeTab, setActiveTab] = useState("I");

    const [loading, setLoading] = useState(true);

    const [error, setError] = useState("");

    // =========================================================
    // LOAD CONFIGURATION DATA
    // =========================================================

    useEffect(() => {

        if (!vehicle?.modelId) {
            setError("Vehicle information is missing.");
            setLoading(false);
            return;
        }

        loadConfigurationData();

    }, [vehicle?.modelId]);

    const loadConfigurationData = async () => {

        try {

            const [
                vehicleData,
                componentData
            ] = await Promise.all([

                getConfigurableVehicleDetails(
                    vehicle.modelId
                ),

                getAdditionalComponents(
                    vehicle.modelId
                )

            ]);

            console.log(
                "Configurable Vehicle Data:",
                vehicleData
            );

            console.log(
                "Additional Components:",
                componentData
            );

            setConfigurableVehicle(
                Array.isArray(vehicleData)
                    ? vehicleData
                    : []
            );

            setAdditionalComponents(
                Array.isArray(componentData)
                    ? componentData
                    : []
            );

        }
        catch (err) {

            console.error(
                "Error loading configuration:",
                err
            );

            setError(
                "Unable to load configurable components."
            );

        }
        finally {

            setLoading(false);

        }

    };

    // =========================================================
    // SELECT ALTERNATE COMPONENT
    // =========================================================

    const handleSelection = (component) => {

        setSelectedComponents(previous => ({

            ...previous,

            [component.compId]: component

        }));

    };

    // =========================================================
    // REMOVE SELECTION
    // =========================================================

    const removeSelection = (compId) => {

        setSelectedComponents(previous => {

            const updated = {
                ...previous
            };

            delete updated[compId];

            return updated;

        });

    };

    // =========================================================
    // GET CONFIGURABLE COMPONENTS BY TYPE
    //
    // VehicleDetailDto contains:
    //
    // CompId
    // ComponentName
    // CompType
    // IsConfigurable
    //
    // C = Core
    // I = Interior
    // E = Exterior
    // S = Standard
    // =========================================================

    const getComponentsByType = (type) => {

        return configurableVehicle.filter(
            component =>
                component.compType?.trim().toUpperCase() === type &&
                component.isConfigurable === true
        );

    };

    // =========================================================
    // GET ALTERNATE COMPONENTS FOR THE SELECTED CATEGORY
    // =========================================================

    const getCategoryComponents = (categoryComponents) => {

        const componentIds = new Set(
            categoryComponents.map(
                component => component.compId
            )
        );

        return additionalComponents.filter(
            additional =>
                componentIds.has(additional.compId)
        );

    };

    // =========================================================
    // CATEGORY DATA
    // =========================================================

    const coreVehicleComponents =
        getComponentsByType("C");

    const interiorVehicleComponents =
        getComponentsByType("I");

    const exteriorVehicleComponents =
        getComponentsByType("E");

    const standardVehicleComponents =
        getComponentsByType("S");

    const coreComponents =
        getCategoryComponents(
            coreVehicleComponents
        );

    const interiorComponents =
        getCategoryComponents(
            interiorVehicleComponents
        );

    const exteriorComponents =
        getCategoryComponents(
            exteriorVehicleComponents
        );

    const standardComponents =
        getCategoryComponents(
            standardVehicleComponents
        );

    // =========================================================
    // ADDITIONAL PRICE
    //
    // Sum selected alternate-component delta prices.
    // =========================================================

    const additionalPrice =
        Object.values(selectedComponents).reduce(
            (total, component) =>
                total + Number(component.deltaPrice || 0),
            0
        );

    // =========================================================
    // BASE TOTAL
    // =========================================================

    const baseTotal =
        Number(vehicle?.basePrice || 0) *
        Number(quantity || 0);

    // =========================================================
    // GRAND TOTAL
    // =========================================================

    const grandTotal =
        baseTotal +
        (
            additionalPrice *
            Number(quantity || 0)
        );

    // =========================================================
    // CONFIRM
    // =========================================================

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

    // =========================================================
    // LOADING
    // =========================================================

    if (loading) {

        return (
            <h2 className="loading-message">
                Loading...
            </h2>
        );

    }

    // =========================================================
    // ERROR
    // =========================================================

    if (error) {

        return (
            <h2 className="error-message">
                {error}
            </h2>
        );

    }

    // =========================================================
    // MAIN UI
    // =========================================================

    return (

        <div className="page-shell">

            <Header isAuthenticated={true} />

            <main className="configure-page">

                <div className="configure-container">

                    {/* =========================================
                        LEFT PANEL
                    ========================================= */}

                    <div className="left-panel">

                        {/* VEHICLE IMAGE */}

                        <div className="vehicle-image-card">

                            <img
                                src={`/${vehicle.imagePath}`}
                                alt={vehicle.modelName}
                            />

                            <div className="vehicle-overlay"></div>

                            <div className="vehicle-name">

                                <h2>
                                    {vehicle.modelName}
                                </h2>

                                <p>
                                    Build your perfect configuration
                                </p>

                            </div>

                        </div>

                        {/* =====================================
                            CATEGORY TABS
                        ===================================== */}

                        <div className="component-tabs">

                            <button
                                className={
                                    activeTab === "I"
                                        ? "active"
                                        : ""
                                }
                                onClick={() =>
                                    setActiveTab("I")
                                }
                            >
                                Interior
                            </button>

                            <button
                                className={
                                    activeTab === "E"
                                        ? "active"
                                        : ""
                                }
                                onClick={() =>
                                    setActiveTab("E")
                                }
                            >
                                Exterior
                            </button>

                            <button
                                className={
                                    activeTab === "S"
                                        ? "active"
                                        : ""
                                }
                                onClick={() =>
                                    setActiveTab("S")
                                }
                            >
                                Standard
                            </button>

                            <button
                                className={
                                    activeTab === "C"
                                        ? "active"
                                        : ""
                                }
                                onClick={() =>
                                    setActiveTab("C")
                                }
                            >
                                Core
                            </button>

                        </div>

                        {/* =====================================
                            COMPONENT CONTENT
                        ===================================== */}

                        <div className="component-content">

                            {activeTab === "I" && (

                                <ConfigurationSection
                                    title="Interior Components"
                                    components={
                                        interiorComponents
                                    }
                                    selectedComponents={
                                        selectedComponents
                                    }
                                    handleSelection={
                                        handleSelection
                                    }
                                    removeSelection={
                                        removeSelection
                                    }
                                />

                            )}

                            {activeTab === "E" && (

                                <ConfigurationSection
                                    title="Exterior Components"
                                    components={
                                        exteriorComponents
                                    }
                                    selectedComponents={
                                        selectedComponents
                                    }
                                    handleSelection={
                                        handleSelection
                                    }
                                    removeSelection={
                                        removeSelection
                                    }
                                />

                            )}

                            {activeTab === "S" && (

                                <ConfigurationSection
                                    title="Standard Components"
                                    components={
                                        standardComponents
                                    }
                                    selectedComponents={
                                        selectedComponents
                                    }
                                    handleSelection={
                                        handleSelection
                                    }
                                    removeSelection={
                                        removeSelection
                                    }
                                />

                            )}

                            {activeTab === "C" && (

                                <ConfigurationSection
                                    title="Core Components"
                                    components={
                                        coreComponents
                                    }
                                    selectedComponents={
                                        selectedComponents
                                    }
                                    handleSelection={
                                        handleSelection
                                    }
                                    removeSelection={
                                        removeSelection
                                    }
                                />

                            )}

                        </div>

                    </div>

                    {/* =========================================
                        RIGHT PANEL
                    ========================================= */}

                    <div className="right-panel">

                        <PriceSummary
                            selectedComponents={
                                selectedComponents
                            }

                            baseTotal={
                                baseTotal
                            }

                            additionalPrice={
                                additionalPrice
                            }

                            quantity={
                                quantity
                            }

                            grandTotal={
                                grandTotal
                            }

                            onConfirm={
                                handleConfirm
                            }
                        />

                    </div>

                </div>

            </main>

            <Footer />

        </div>

    );

};

export default Configure;