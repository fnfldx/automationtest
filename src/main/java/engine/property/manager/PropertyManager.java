package engine.property.manager;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
public class PropertyManager {
  private static PropertyManager instance;
  private static Properties properties;

  static {
    properties = new Properties();
    var configPath = "src/main/resources/config.properties";
    try (FileInputStream input = new FileInputStream(configPath)) {
      properties.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private PropertyManager() {
    // Private constructor to prevent instantiation from outside
  }

  public static synchronized PropertyManager getInstance() {
    if (instance == null) {
      instance = new PropertyManager();
    }
    return instance;
  }

  public static String getProperty(PropertyKeys key) {
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