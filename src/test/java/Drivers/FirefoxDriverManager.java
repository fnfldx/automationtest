package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager {
    public WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("-private");

        return (WebDriver) new FirefoxDriverManager();
    }
}
