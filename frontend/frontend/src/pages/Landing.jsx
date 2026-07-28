import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Header from "../components/Header";
import Footer from "../components/Footer";
import "./Landing.css";

export default function Landing({ isAuthenticated }) {
  const navigate = useNavigate();

  const handleConfigureClick = () => {
    if (!isAuthenticated) {
      toast.info("Please log in to configure a vehicle.");
      navigate("/login", { state: { from: "/configure-vehicle" } });
    } else {
      navigate("/configure-vehicle");
    }
  };

  const handleRegisterClick = () => {
    navigate("/register");
  };

  return (
    <div className="page-shell">
      <Header isAuthenticated={isAuthenticated} />

      <main className="hero">
        <div className="hero-cut" aria-hidden="true" />

        <div className="container hero-content">
          <h1 className="hero-title">
            Rent Smarter
            <span className="accent"> Backed by Finance</span>
            <span className="hero-sub">Flexible car rentals, financed and managed for you</span>
          </h1>

          <p className="hero-copy">
            AutoDeal is a finance-backed car rental platform. Onboard your
            company and configure vehicles from our fleet for rental, with
            financing built into every plan.
          </p>

          <section className="action-panel" aria-label="Get started">
            <button className="action-card action-card--primary" onClick={handleConfigureClick}>
              <span className="action-eyebrow">For fleet managers</span>
              <span className="action-title">Configure Vehicle</span>
              <span className="action-desc">
                Set up a rental vehicle by segment, manufacturer &amp; model.
              </span>
            </button>

            <button className="action-card action-card--secondary" onClick={handleRegisterClick}>
              <span className="action-eyebrow">New here?</span>
              <span className="action-title">Company Registration</span>
              <span className="action-desc">
                Register your company to start renting vehicles from our fleet.
              </span>
            </button>
          </section>
        </div>
      </main>

      <Footer />
    </div>
  );
}
