package engine.property.manager;

import java.util.Properties;

public interface ConfigurationProvider {
    String getProperty(String key);
    void setProperty(String key, String value);
}