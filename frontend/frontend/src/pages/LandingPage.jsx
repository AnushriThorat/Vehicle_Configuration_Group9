import { Link } from "react-router-dom";
import { Car, Settings, ShieldCheck, Search } from "lucide-react";
import "../styles/LandingPage.css";

function LandingPage() {

    return (
        <div className="landing-page">

            {/* Hero Section */}
            <section className="hero-section">

                <div className="hero-text">

                    <h1>
                        Build Your Perfect
                        <span> Vehicle Configuration</span>
                    </h1>

                    <p>
                        Explore vehicles, select models, customize components,
                        and create a configuration that matches your requirements.
                    </p>


                    <div className="hero-actions">

                        <Link to="/login" className="primary-btn">
                            Get Started
                        </Link>

                        <Link to="/register" className="outline-btn">
                            Create Account
                        </Link>

                    </div>

                </div>


                <div className="hero-image">

                    <Car size={220}/>

                </div>


            </section>



            {/* Features */}

            <section className="feature-section">

                <h2>
                    Why Choose Vehicle Configurator?
                </h2>


                <div className="feature-container">


                    <div className="feature-card">

                        <Car size={45}/>

                        <h3>
                            Vehicle Selection
                        </h3>

                        <p>
                            Browse different manufacturers, segments,
                            and vehicle models.
                        </p>

                    </div>



                    <div className="feature-card">

                        <Settings size={45}/>

                        <h3>
                            Smart Configuration
                        </h3>

                        <p>
                            Configure vehicle components based on your needs.
                        </p>

                    </div>




                    <div className="feature-card">

                        <ShieldCheck size={45}/>

                        <h3>
                            Secure Access
                        </h3>

                        <p>
                            Authentication and user management with secure access.
                        </p>

                    </div>




                    <div className="feature-card">

                        <Search size={45}/>

                        <h3>
                            Explore Models
                        </h3>

                        <p>
                            Easily search and view available vehicle options.
                        </p>

                    </div>


                </div>


            </section>


        </div>
    );
}


export default LandingPage;