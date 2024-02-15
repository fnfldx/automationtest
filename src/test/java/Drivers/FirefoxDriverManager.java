package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager {
    public WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/resources/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("-width", "1920", "-height", "1080");
        options.addArguments("-private");

        return new FirefoxDriver(options);
    }
}
