package engine.drivers;

import enums.BrowserName;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver getWebDriver(BrowserName browserName) {
        return switch (browserName) {
            case CHROME -> new ChromeDriverManager().getDriver();
            case FIREFOX -> new FirefoxDriverManager().getDriver();
            default -> throw new UnsupportedOperationException("For now the only supported browsers are Google Chrome and Mozilla Firefox.");
        };
    }
}