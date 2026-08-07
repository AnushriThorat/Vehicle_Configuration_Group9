import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const OAuthSuccess = () => {

    const navigate = useNavigate();

    useEffect(() => {

        const params = new URLSearchParams(window.location.search);

        const token = params.get("token");

        const userId = params.get("userId");

        const username = params.get("username");

        if (token) {

            sessionStorage.setItem("token", token);

            sessionStorage.setItem("userId", userId);

            sessionStorage.setItem("username", username);

            navigate("/");

        }
        else {

            navigate("/login");

        }

    }, [navigate]);

    return (

        <div
            style={{
                height: "100vh",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                fontSize: "24px",
                fontWeight: "bold"
            }}
        >
            Signing in with Google...
        </div>

    );

};

export default OAuthSuccess;