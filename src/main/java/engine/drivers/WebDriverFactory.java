package engine.drivers;

import engine.exceptions.UnsupportedBrowserException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

import static engine.property.manager.PropertyManager.getBrowserName;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebDriverFactory {
    private static WebDriver webDriverInstance;

    @SneakyThrows
    public static synchronized WebDriver getWebDriverInstance() {
        if (webDriverInstance == null) {
            webDriverInstance = createWebDriverInstance();
        }
        return webDriverInstance;
    }

    @SneakyThrows
    public static WebDriver createWebDriverInstance() {
        return switch (getBrowserName()) {
            case CHROME -> new ChromeDriverManager().getDriver();
            case FIREFOX -> new FirefoxDriverManager().getDriver();
            default -> throw new UnsupportedBrowserException(getBrowserName().toString());
        };
    }

    @SneakyThrows
    public static void quitWebDriver() {
        if (webDriverInstance != null) {
            webDriverInstance.quit();
        }
    }
}