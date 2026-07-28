import { Link } from "react-router-dom";
import "./Header.css";

export default function Header({ isAuthenticated }) {
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
          {isAuthenticated && <span className="status-pill">Signed in</span>}
          <Link to="/login" className="header-login">
            Log in
          </Link>
        </div>
      </div>
    </header>
  );
}
