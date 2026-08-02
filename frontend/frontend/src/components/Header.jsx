import { Link, useNavigate } from "react-router-dom";
import "./Header.css";

export default function Header({ isAuthenticated }) {
  const navigate = useNavigate();

  const username = sessionStorage.getItem("username");

  const handleLogout = () => {
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("username");

    navigate("/login", { replace: true });
    window.location.reload();
  };

  return (
    <header className="site-header">
      <div className="container header-inner">

        <Link to="/" className="brand">
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

        <nav className="main-nav">

          {!isAuthenticated && (
            <Link to="/register">
              Registration
            </Link>
          )}

          <a href="#fleet">Our Fleet</a>

          <a href="#contact">Contact Us</a>

        </nav>

        <div className="header-actions">

          {isAuthenticated ? (
            <>
              <span className="status-pill">
                Welcome, {username}
              </span>

              <button
                className="header-login"
                onClick={handleLogout}
              >
                Logout
              </button>
            </>
          ) : (
            <Link
              to="/login"
              className="header-login"
            >
              Log In
            </Link>
          )}

        </div>

      </div>
    </header>
  );
}