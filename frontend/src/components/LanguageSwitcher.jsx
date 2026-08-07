import { useTranslation } from "react-i18next";

const LanguageSwitcher = () => {

    const { i18n } = useTranslation();

    const changeLanguage = (event) => {

        const language = event.target.value;

        i18n.changeLanguage(language);

        localStorage.setItem("language", language);

    };

    return (

        <div className="language-switcher">

            <span className="language-icon">

                🌐

            </span>

            <select

                value={i18n.language}

                onChange={changeLanguage}

            >

                <option value="en">

                    🇺🇸 English

                </option>

                <option value="hi">

                    🇮🇳 हिन्दी

                </option>

                <option value="mr">

                    🇮🇳 मराठी

                </option>

                <option value="te">

                    🇮🇳 తెలుగు

                </option>

                <option value="kn">

                    🇮🇳 ಕನ್ನಡ

                </option>

            </select>

        </div>

    );

};

export default LanguageSwitcher;