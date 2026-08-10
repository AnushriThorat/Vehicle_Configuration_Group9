import "./Footer.css";
import LanguageSwitcher from "../components/LanguageSwitcher";

export default function Footer() {
  return (
    <footer className="site-footer">
      <div className="container footer-inner">
        <span>© {new Date().getFullYear()} AutoDeal Inc. All rights reserved.</span>
        <div className="footer-links">
          <a href="#privacy">Privacy</a>
          <a href="#terms">Terms</a>
          <a href="#support">Support</a>
           <LanguageSwitcher />
        </div>
      </div>
    </footer>
  );
}
