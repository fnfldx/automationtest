package engine.property.manager;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyManager {
  private static PropertyManager instance;
  private static final Properties properties;

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