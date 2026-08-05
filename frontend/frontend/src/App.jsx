import { Routes, Route, Navigate } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import Landing from "./pages/Landing";
import Login from "./pages/Login";
import Registration from "./pages/Registration";
import VehicleConfiguration from "./pages/VehicleConfiguration";
import VehicleDetails from "./pages/VehicleDetails";
import Configure from "./pages/Configure";
import Invoice from "./pages/invoice";
import OAuthSuccess from "./pages/OAuthSuccess";
import Contact from "./pages/Contact";
import About from "./pages/About";

export default function App() {

  const isAuthenticated = Boolean(sessionStorage.getItem("token"));

  return (
    <>
      <Routes>
        {/* Landing */}
        <Route
          path="/"
          element={
            <Landing
              isAuthenticated={isAuthenticated}
            />
          }
        />
 {/* About Us */}
        <Route
    path="/about"
    element={
        <About
            isAuthenticated={isAuthenticated}
        />
    }
/>

{/* Contact Us */}
<Route
    path="/contact"
    element={
        <Contact
            isAuthenticated={isAuthenticated}
        />
    }
/>

        {/* Login */}
        <Route
          path="/login"
          element={
            isAuthenticated ? (
              <Navigate
                to="/configure-vehicle"
                replace
              />
            ) : (
              <Login
                onLoginSuccess={() => window.location.reload()}
              />
            )
          }
        />

        {/* SSO OAuth2*/}
        <Route
  path="/oauth-success"
  element={<OAuthSuccess />}
/>

        {/* Registration */}
        <Route
          path="/register"
          element={
            isAuthenticated ? (
              <Navigate
                to="/configure-vehicle"
                replace
              />
            ) : (
              <Registration />
            )
          }
        />

        {/* Vehicle Configuration */}
        <Route
          path="/configure-vehicle"
          element={
            isAuthenticated ? (
              <VehicleConfiguration />
            ) : (
              <Navigate
                to="/login"
                state={{ from: "/configure-vehicle" }}
                replace
              />
            )
          }
        />

        {/* Vehicle Details */}
        <Route
          path="/vehicle-details"
          element={
            isAuthenticated ? (
              <VehicleDetails />
            ) : (
              <Navigate
                to="/login"
                replace
              />
            )
          }
        />

        {/* Configure */}
        <Route
          path="/configure"
          element={
            isAuthenticated ? (
              <Configure />
            ) : (
              <Navigate
                to="/login"
                replace
              />
            )
          }
        />

        {/* Invoice */}
        <Route
          path="/invoice"
          element={
            isAuthenticated ? (
              <Invoice />
            ) : (
              <Navigate
                to="/login"
                replace
              />
            )
          }
        />

        {/* Invalid URL */}
        <Route
          path="*"
          element={<Navigate to="/" replace />}
        />

      </Routes>

      <ToastContainer
        position="top-right"
        autoClose={3500}
        newestOnTop
        theme="dark"
      />
    </>
  );
}