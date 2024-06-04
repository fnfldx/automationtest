package engine.property.manager;

import enums.BrowserName;
import enums.Currency;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Cookie;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyManager {
    private static final Properties properties;
    private static PropertyManager propertyManagerInstance;

    static {
        properties = new Properties();
        var configPath = "src/main/resources/config.properties";
        try (FileInputStream input = new FileInputStream(configPath)) {
            properties.load(input);
        } catch (IOException ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, "Error loading properties", ex);
        }
    }

    public static synchronized PropertyManager getPropertyManagerInstance() {
        if (propertyManagerInstance == null) {
            propertyManagerInstance = new PropertyManager();
        }
        return propertyManagerInstance;
    }

    public static String getProperty(PropertyKeys key) {
        return properties.getProperty(key.toString());
    }

    public static void setProperty(String systemProperty, String systemStringValue) {
        System.setProperty(systemProperty, systemStringValue);
    }

    public static BrowserName getBrowserName() {
        return BrowserName.valueOf(getProperty(PropertyKeys.BROWSER_NAME));

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
        COOKIE_CURRENCY
    }
}