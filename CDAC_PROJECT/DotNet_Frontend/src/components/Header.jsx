import { Link, useNavigate } from "react-router-dom";
import { useTranslation } from "react-i18next";

import "./Header.css";

export default function Header({ isAuthenticated }) {

  const navigate = useNavigate();

  const { t } = useTranslation();

  const username = sessionStorage.getItem("username");

  const handleLogout = () => {

    sessionStorage.clear();

    navigate("/login", {
      replace: true
    });

    window.location.reload();

  };

  return (

    <header className="site-header">

      <div className="container header-inner">

        {/* Logo */}

        <Link
          to="/"
          className="brand"
        >

          <img
            src="/images/logo.jpeg"
            alt="9 Wheels Leasing Services"
            className="brand-logo"
          />

          <div className="brand-text">

            <span className="brand-name">

              9 Wheels

            </span>

            <span className="brand-subtitle">

              Leasing Services

            </span>

          </div>

        </Link>

        {/* Navigation */}

        <nav className="main-nav">

          <Link to="/">

            {t("home")}

          </Link>

          {!isAuthenticated && (

            <Link to="/register">

              {t("registration")}

            </Link>

          )}

          <Link to="/about">

            {t("about")}

          </Link>

          <Link to="/contact">

            {t("contact")}

          </Link>

        </nav>

        {/* Right Side */}

        <div className="header-actions">

          {isAuthenticated ? (

            <>

              <span className="status-pill">

                {t("welcome")}, {username}

              </span>

              <button
                className="header-login"
                onClick={handleLogout}
              >

                {t("logout")}

              </button>

            </>

          ) : (

            <Link
              to="/login"
              className="header-login"
            >

              {t("login")}

            </Link>

          )}

        </div>

      </div>

    </header>

  );

}