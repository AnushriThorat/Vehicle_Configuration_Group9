import "./ConfigurationSection.css";

const ConfigurationSection = ({
    title,
    components,
    selectedComponents,
    handleSelection,
    removeSelection
}) => {

    // Group all alternate components by original component
    const groupedComponents = components.reduce((groups, item) => {

        if (!groups[item.compId]) {

            groups[item.compId] = {

                compId: item.compId,
                componentName: item.componentName,
                options: []

            };

        }

        groups[item.compId].options.push(item);

        return groups;

    }, {});

    return (

        <div className="configuration-section">

            <h3>{title}</h3>

            {

                Object.values(groupedComponents).length === 0 ?

                    <p className="no-component">

                        No configurable components available.

                    </p>

                    :

                    Object.values(groupedComponents).map(component => (

                        <div
                            className="configuration-item"
                            key={component.compId}
                        >

                            <h4>

                                {component.componentName}

                            </h4>

                            {/* Original */}

                            <div

                                className={
                                    !selectedComponents[component.compId]
                                        ? "selection-card active"
                                        : "selection-card"
                                }

                                onClick={() =>
                                    removeSelection(component.compId)
                                }

                            >

                                <div>

                                    <strong>

                                        {component.componentName}

                                        

                                    </strong>

                                    <p>

                                        Original

                                    </p>

                                </div>

                                <span className="included">

                                    Included

                                </span>

                            </div>

                            {/* Alternate Components */}

                            {

                                component.options.map(option => (

                                    <div

                                        key={option.altId}

                                        className={

                                            selectedComponents[component.compId]?.altId === option.altId

                                                ? "selection-card active"

                                                : "selection-card"

                                        }

                                        onClick={() =>

                                            handleSelection(option)

                                        }

                                    >

                                        <div>

                                            <strong>

                                                {option.alternateComponentName}

                                            </strong>

                                            <p>

                                                Upgrade

                                            </p>

                                        </div>

                                        <span className="price-tag">

                                            {option.deltaPrice >= 0

                                                ? `+₹${option.deltaPrice.toLocaleString("en-IN")}`

                                                : `-₹${Math.abs(option.deltaPrice).toLocaleString("en-IN")}`}

                                        </span>

                                    </div>

                                ))

                            }

                        </div>

                    ))

            }

        </div>

    );

};

export default ConfigurationSection;