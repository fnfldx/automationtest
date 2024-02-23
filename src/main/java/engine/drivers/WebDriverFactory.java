package engine.drivers;

import engine.exceptions.UnsupportedBrowserException;
import enums.BrowserName;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    @SneakyThrows
    public static WebDriver getWebDriver(BrowserName browserName) {
        return switch (browserName) {
            case CHROME -> new ChromeDriverManager().getDriver();
            case FIREFOX -> new FirefoxDriverManager().getDriver();
            default -> throw new UnsupportedBrowserException(browserName.toString());
        };
    }
}