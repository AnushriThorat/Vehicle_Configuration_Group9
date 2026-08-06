import { useTranslation } from "react-i18next";

import Header from "../components/Header";
import Footer from "../components/Footer";

import "./About.css";

export default function About({ isAuthenticated }) {

  const { t } = useTranslation();

  return (

    <div className="page-shell">

      <Header isAuthenticated={isAuthenticated} />

      <main className="about-page">

        {/* Hero */}

        <section className="about-hero">

          <div className="container">

            <h1>

              {t("aboutTitle")}

            </h1>

            <p>

              {t("aboutSubtitle")}

            </p>

          </div>

        </section>

        {/* Company */}

        <section className="about-section container">

          <h2>

            {t("whoWeAre")}

          </h2>

          <p>

            {t("whoWeAreDesc")}

          </p>

        </section>

        {/* Mission Vision */}

        <section className="mission-grid container">

          <div className="mission-card">

            <h3>

              🎯 {t("mission")}

            </h3>

            <p>

              {t("missionDesc")}

            </p>

          </div>

          <div className="mission-card">

            <h3>

              🚀 {t("vision")}

            </h3>

            <p>

              {t("visionDesc")}

            </p>

          </div>

        </section>

        {/* Features */}

        <section className="container">

          <h2 className="section-title">

            {t("whyChooseUs")}

          </h2>

          <div className="feature-grid">

            <div className="feature-card">

              🚗

              <h3>

                {t("vehicleConfig")}

              </h3>

            </div>

            <div className="feature-card">

              🔐

              <h3>

                {t("secureLogin")}

              </h3>

            </div>

            <div className="feature-card">

              📄

              <h3>

                {t("invoiceGeneration")}

              </h3>

            </div>

            <div className="feature-card">

              ☁️

              <h3>

                {t("cloudReady")}

              </h3>

            </div>

            <div className="feature-card">

              📧

              <h3>

                {t("emailSupport")}

              </h3>

            </div>

            <div className="feature-card">

              🌎

              <h3>

                {t("multiLanguage")}

              </h3>

            </div>

          </div>

        </section>

      </main>

      <Footer />

    </div>

  );

}