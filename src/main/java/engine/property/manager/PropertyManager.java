package engine.property.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
  public static String getProperty(PropertyKeys key) {
    var properties = new Properties();
    var configPath = "src/main/resources/config.properties";
    try (FileInputStream input = new FileInputStream(configPath)) {
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
      FIREFOX_DRIVER,
      BASE_URL,
      BASE_WAIT_IN_SECONDS
  }
}