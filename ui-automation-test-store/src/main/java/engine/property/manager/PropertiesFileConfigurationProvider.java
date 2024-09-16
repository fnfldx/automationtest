package engine.property.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileConfigurationProvider implements ConfigurationProvider {
    private final Properties properties = new Properties();

    public PropertiesFileConfigurationProvider(String filePath) {
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    @Override
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}