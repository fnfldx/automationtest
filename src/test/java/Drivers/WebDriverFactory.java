package Drivers;

import Enums.BrowserName;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver getWebDriver(BrowserName browserName) {
        return switch (browserName) {
            case Chrome -> new ChromeDriverManager().getDriver();
            case Firefox -> new FirefoxDriverManager().getDriver();
            default ->
                    throw new UnsupportedOperationException("This method is not implemented yet"); //to discuss what exact Exception this should throw
        };
    }
}