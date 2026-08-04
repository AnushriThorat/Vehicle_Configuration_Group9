import { useEffect, useState } from "react";
import { FaCheckCircle } from "react-icons/fa";
import "./OrderSuccessModal.css";

const OrderSuccessModal = ({ onFinish }) => {

    const [count, setCount] = useState(8);

    useEffect(() => {

        const timer = setInterval(() => {

            setCount(prev => {

                if (prev === 1) {

                    clearInterval(timer);

                    onFinish();

                    return 0;

                }

                return prev - 1;

            });

        }, 1000);

        return () => clearInterval(timer);

    }, [onFinish]);

    return (

        <div className="success-overlay">

            <div className="success-modal">

                <FaCheckCircle className="success-icon" />

                <h2>Order Successful!</h2>

                <p className="success-message">

                    Your vehicle order has been placed successfully.

                </p>

                <p>

                    Your invoice has been generated successfully.

                </p>

                <p>

                    Thank you for choosing

                    <strong>

                        {" "}9 Wheels Leasing Services

                    </strong>

                </p>

                <div className="delivery-box">

                    <h4>Estimated Delivery</h4>

                    <span>4 - 6 Weeks</span>

                </div>

                <p className="redirect-text">

                    Redirecting to Home Page in

                    <strong>

                        {" "} {count} sec

                    </strong>

                </p>

            </div>

        </div>

    );

};

export default OrderSuccessModal;