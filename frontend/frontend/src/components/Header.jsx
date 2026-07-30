import { Link, useNavigate } from "react-router-dom";
import "./Header.css";

export default function Header({ isAuthenticated }) {

  const navigate = useNavigate();

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
          <span className="brand-mark">AD</span>
          <span className="brand-name">AutoDeal</span>
        </Link>

        <nav className="main-nav">
          <Link to="/register">Registration</Link>
          <a href="#fleet">Our Fleet</a>
          <a href="#contact">Contact Us</a>
        </nav>

        <div className="header-actions">

          {isAuthenticated ? (
            <>
              <span className="status-pill">
                Signed In
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