import { useTranslation } from "react-i18next";

import Header from "../components/Header";
import Footer from "../components/Footer";

import "./Contact.css";

export default function Contact({ isAuthenticated }) {

  const { t } = useTranslation();

  return (

    <div className="page-shell">

      <Header isAuthenticated={isAuthenticated} />

      <main className="contact-page">

        <section className="contact-hero">

          <h1>{t("contactTitle")}</h1>

          <p>{t("contactSubtitle")}</p>

        </section>

        <div className="contact-container">

          <div className="contact-info">

            <div className="info-card">

              <h3>📍 {t("address")}</h3>

              <p>

                9 Wheels Leasing Services

                <br />

                Pune, Maharashtra

                <br />

                India

              </p>

            </div>

            <div className="info-card">

              <h3>📞 {t("phone")}</h3>

              <p>

                +91 9876543210

              </p>

            </div>

            <div className="info-card">

              <h3>✉ {t("email")}</h3>

              <p>

                support@9wheels.com

              </p>

            </div>

            <div className="info-card">

              <h3>🕒 {t("businessHours")}</h3>

              <p>

                Monday - Friday

                <br />

                9:00 AM - 6:00 PM

              </p>

            </div>

          </div>

          <div className="contact-form-card">

            <h2>

              {t("sendMessage")}

            </h2>

            <form>

              <input
                type="text"
                placeholder={t("yourName")}
              />

              <input
                type="email"
                placeholder={t("yourEmail")}
              />

              <input
                type="text"
                placeholder={t("subject")}
              />

              <textarea
                rows="6"
                placeholder={t("message")}
              />

              <button type="submit">

                {t("send")}

              </button>

            </form>

          </div>

        </div>

      </main>

      <Footer />

    </div>

  );

}