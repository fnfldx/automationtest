package engine.drivers;

import engine.exceptions.UnsupportedBrowserException;
import enums.BrowserName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebDriverFactory {
    private static WebDriver webDriverInstance;

    @SneakyThrows
    public static synchronized WebDriver getWebDriverInstance(BrowserName browserName) {
        if (webDriverInstance == null) {
            webDriverInstance = createWebDriverInstance(browserName);
        }
        return webDriverInstance;
    }

    @SneakyThrows
    public static WebDriver createWebDriverInstance(BrowserName browserName) {
        return switch (browserName) {
            case CHROME -> new ChromeDriverManager().getDriver();
            case FIREFOX -> new FirefoxDriverManager().getDriver();
            default -> throw new UnsupportedBrowserException(browserName.toString());
        };
    }

    @SneakyThrows
    public static void quitWebDriver() {
        if (webDriverInstance != null) {
            webDriverInstance.quit();
        }
    }
}