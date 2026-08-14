import "./PriceSummary.css";

const PriceSummary = ({
    selectedComponents,
    baseTotal,
    additionalPrice,
    quantity,
    grandTotal,
    onConfirm
}) => {

    const addOnTotal = additionalPrice * quantity;

    const totalPerUnit = grandTotal / quantity;

    return (

        <div className="modern-summary-card">

            <div className="summary-header">

                <div className="summary-icon">

                    🛒

                </div>

                <div>

                    <h2>Price Summary</h2>

                    <p>
                        Review your configuration
                    </p>

                </div>

            </div>

            <div className="secure-tag">

                🔒 Secure Configuration

            </div>

            <div className="summary-body">

                <div className="modern-row">

                    <span>

                        Base Price

                    </span>

                    <strong>

                        ₹ {baseTotal.toLocaleString("en-IN")}

                    </strong>

                </div>

                <div className="modern-row">

                    <span>

                        Add-ons Total

                    </span>

                    <strong className="green">

                        + ₹ {addOnTotal.toLocaleString("en-IN")}

                    </strong>

                </div>

                <div className="modern-row">

                    <span>

                        Total Per Unit

                    </span>

                    <strong>

                        ₹ {totalPerUnit.toLocaleString("en-IN")}

                    </strong>

                </div>

                <div className="modern-row">

                    <span>

                        Quantity

                    </span>

                    <strong>

                        {quantity}

                    </strong>

                </div>

            </div>

            <div className="grand-total-box">

                <p>

                    Grand Total

                </p>

                <h1>

                    ₹ {grandTotal.toLocaleString("en-IN")}

                </h1>

                <span>

                    Including all applicable taxes

                </span>

            </div>

            <div className="summary-buttons">

                <button

                    className="cancel-button"

                    onClick={() => window.history.back()}

                >

                    ← Back

                </button>

                <button

                    className="confirm-button"

                    onClick={onConfirm}

                >

                    Confirm Order →

                </button>

            </div>

            <div className="summary-footer">

                🔐 Your configuration and pricing are securely processed.

            </div>

        </div>

    );

};

export default PriceSummary;