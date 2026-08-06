import { useNavigate } from "react-router-dom";
import { useTranslation } from "react-i18next";
import { toast } from "react-toastify";

import { FaCarSide } from "react-icons/fa";
import { HiBuildingOffice2 } from "react-icons/hi2";

import Header from "../components/Header";
import Footer from "../components/Footer";

import "./Landing.css";

export default function Landing({ isAuthenticated }) {

    const navigate = useNavigate();

    const { t } = useTranslation();

    const handleConfigureClick = () => {

        if (!isAuthenticated) {

            toast.info(t("pleaseLogin"));

            navigate("/login", {
                state: {
                    from: "/configure-vehicle"
                }
            });

            return;
        }

        navigate("/configure-vehicle");

    };

    const handleRegisterClick = () => {

        navigate("/register");

    };

    return (

        <div className="landing-page">

            <Header isAuthenticated={isAuthenticated} />

            <main>

                <section className="hero-section">

                    <div className="hero-overlay"></div>

                    <div className="hero-content">

                        <h1 className="hero-title">

                            Enterprise-Ready

                            <br />

                            <span>

                                Vehicle Configuration

                            </span>

                            <br />

                            Platform

                        </h1>
                        <div className="hero-buttons">

                            <button
                                type="button"
                                className="configure-btn"
                                onClick={handleConfigureClick}
                            >

                                <FaCarSide />

                                <span>

                                    {t("configureVehicle")}

                                </span>

                            </button>

                            <button
                                type="button"
                                className="register-btn"
                                onClick={handleRegisterClick}
                            >

                                <HiBuildingOffice2 />

                                <span>

                                    {t("companyRegistration")}

                                </span>

                            </button>

                        </div>

                    </div>

                </section>

            </main>

            <Footer />

        </div>

    );

}