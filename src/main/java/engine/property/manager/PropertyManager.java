package engine.property.manager;

import enums.BrowserName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyManager {
    private static final Properties properties;
    public static ResourceBundle tr;
    private static PropertyManager propertyManagerInstance;
    private static Locale locale;

    static {
        properties = new Properties();
        var configPath = "src/main/resources/config.properties";
        try (FileInputStream input = new FileInputStream(configPath)) {
            properties.load(input);
            setTranslation();
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

    private static void setTranslation() {
        locale = new Locale(getProperty(PropertyKeys.LANG));
        Locale.setDefault(locale);
        tr = ResourceBundle.getBundle("translations.translation", locale);
    }

    public enum PropertyKeys {
        CHROME_DRIVER,
        FIREFOX_DRIVER,
        BROWSER_NAME,
        BASE_URL,
        BASE_WAIT_IN_SECONDS,
        LANG
    }
}
