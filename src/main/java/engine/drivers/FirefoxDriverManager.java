package engine.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static enums.BrowserName.FIREFOX;
import static engine.config.reader.ConfigReader.PropertyKeys.FIREFOX_DRIVER;
import static engine.config.reader.ConfigReader.getProperty;
import static engine.config.reader.ConfigReader.setProperty;

public class FirefoxDriverManager implements WebDriverInterface {
    @Override
    public void setWebDriverPath() {
        setProperty(FIREFOX.webDriverPathProperty, getProperty(FIREFOX_DRIVER));
    }
    @Override
    public WebDriver getDriver() {
        setWebDriverPath();
        return new FirefoxDriver();
    }
}