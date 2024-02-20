package engine.config.reader;

import engine.drivers.WebDriverFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static String getProperty(PropertyKeys key) {
        var properties = new Properties();
        try (InputStream input = WebDriverFactory.class.getResourceAsStream("/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(key.toString());
    }

    public static void setProperty(String systemProperty, String systemStringValue) {
        System.setProperty(systemProperty, systemStringValue);
    }

    public enum PropertyKeys {
        CHROME_DRIVER,
        FIREFOX_DRIVER
    }

}