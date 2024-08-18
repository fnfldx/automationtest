package engine.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static engine.property.manager.PropertyManager.PropertyKeys.CHROME_DRIVER;
import static engine.property.manager.PropertyManager.getProperty;
import static engine.property.manager.PropertyManager.setProperty;
import static enums.BrowserName.CHROME;

public class ChromeDriverManager implements WebDriverInterface {

    @Override
    public void setWebDriverPath() {
        setProperty(CHROME.webDriverPathProperty, getProperty(CHROME_DRIVER));
    }

    @Override
    public WebDriver getDriver() {
        setWebDriverPath();

        var options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("start-maximized");
        options.addArguments("--search-engine-choice-country");

        return new ChromeDriver(options);
    }
}