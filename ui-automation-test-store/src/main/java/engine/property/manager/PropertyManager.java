package engine.property.manager;

import enums.BrowserName;
import enums.Currency;
import lombok.Getter;
import org.openqa.selenium.Cookie;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class PropertyManager {
    private static final Logger LOGGER = Logger.getLogger(PropertyManager.class.getName());
    private static ConfigurationProvider configProvider;
    private static PropertyManager propertyManagerInstance;
    private static Locale locale;
    public static ResourceBundle tr;

    private PropertyManager(ConfigurationProvider configProvider) {
        this.configProvider = configProvider;
        setTranslation();
        logProperties();
    }

    public static synchronized PropertyManager getPropertyManagerInstance() {
        if (propertyManagerInstance == null) {
            var configFileProvider = new PropertiesFileConfigurationProvider("src/main/resources/config.properties");
            propertyManagerInstance = new PropertyManager(configFileProvider);
        }
        return propertyManagerInstance;
    }

    private static void logProperties() {
        for (PropertyKeys key : PropertyKeys.values()) {
            LOGGER.log(Level.INFO, key + ": " + getProperty(key));
        }
    }

    public static String getProperty(PropertyKeys key) {
        return configProvider.getProperty(key.toString());
    }

    public static void setProperty(String systemProperty, String systemStringValue) {
        System.setProperty(systemProperty, systemStringValue);
    }

    public static BrowserName getBrowserName() {
        return BrowserName.valueOf(getProperty(PropertyKeys.BROWSER_NAME));
    }

    private static void setTranslation() {
        locale = new Locale(getProperty(PropertyKeys.LANG));
        Locale.setDefault(locale);
        tr = ResourceBundle.getBundle("translations.translation", locale);
    }

    public static Currency getCurrency() {
        return Currency.valueOf(getProperty(PropertyKeys.COOKIE_CURRENCY));
    }

    // Add more 'get' methods here if new Cookie properties are added
    public static Set<Cookie> getCookiesFromProperty() {
        return Set.of(getCurrencyCookieFromProperties());
    }

    private static Cookie getCurrencyCookieFromProperties() {
        return new Cookie("currency", getProperty(PropertyKeys.COOKIE_CURRENCY));
    }

    public enum PropertyKeys {
        CHROME_DRIVER,
        FIREFOX_DRIVER,
        BROWSER_NAME,
        BASE_URL,
        BASE_WAIT_IN_SECONDS,
        COOKIE_CURRENCY,
        LANG
    }
}