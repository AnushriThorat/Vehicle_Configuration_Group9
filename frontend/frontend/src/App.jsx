import { useState } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import Landing from "./pages/Landing";
import Login from "./pages/Login";
import Registration from "./pages/Registration";
import VehicleConfig from "./pages/VehicleConfig";

export default function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(
    () => Boolean(localStorage.getItem("authToken"))
  );

  const handleLoginSuccess = () => setIsAuthenticated(true);

  return (
    <>
      <Routes>
        <Route path="/" element={<Landing isAuthenticated={isAuthenticated} />} />
        <Route path="/login" element={<Login onLoginSuccess={handleLoginSuccess} />} />
        <Route path="/register" element={<Registration />} />
        <Route
          path="/configure-vehicle"
          element={
            isAuthenticated ? (
              <VehicleConfig />
            ) : (
              <Navigate to="/login" state={{ from: "/configure-vehicle" }} replace />
            )
          }
        />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>

      <ToastContainer
        position="top-right"
        autoClose={3500}
        theme="dark"
        newestOnTop
      />
    </>
  );
}
