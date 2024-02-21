package engine.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static engine.config.reader.ConfigReader.PropertyKeys.CHROME_DRIVER;
import static engine.config.reader.ConfigReader.getProperty;
import static engine.config.reader.ConfigReader.setProperty;
import static enums.BrowserName.CHROME;

public class ChromeDriverManager implements WebDriverInterface {
    @Override
    public void setWebDriverPath() {
        setProperty(CHROME.webDriverPathProperty, getProperty(CHROME_DRIVER));
    }

    @Override
    public WebDriver getDriver() {
        setWebDriverPath();
        return new ChromeDriver();
    }
}