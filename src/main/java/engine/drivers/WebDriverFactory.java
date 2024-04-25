package engine.drivers;

import engine.cookie.manager.CookieManager;
import engine.exceptions.UnsupportedBrowserException;
import enums.Currency;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import static engine.property.manager.PropertyManager.getBrowserName;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebDriverFactory {
    private static WebDriver webDriverInstance;

    public static synchronized WebDriver getWebDriverInstance() {
        if (webDriverInstance == null) {
            webDriverInstance = createWebDriverInstance();
        }
        return webDriverInstance;
    }

    @SneakyThrows
    public static WebDriver createWebDriverInstance() {
        WebDriver driver = switch (getBrowserName()) {
            case CHROME -> new ChromeDriverManager().getDriver();
            case FIREFOX -> new FirefoxDriverManager().getDriver();
            default -> throw new UnsupportedBrowserException(getBrowserName().toString());
        };
        setCookies(driver);
        return driver;
    }

    public static void quitWebDriver() {
        if (webDriverInstance != null) {
            webDriverInstance.quit();
            webDriverInstance = null;
        }
    }

    private static void setCookies(WebDriver driver) {
        var cookieManager = CookieManager.getCookieManagerInstance();
        for (Cookie cookie : cookieManager.getCookies()) {
            driver.manage().addCookie(cookie);
        }
    }

    public static void setGlobalCurrency(Currency currency) {
        Currency.setGlobalCurrency(currency);
        if (webDriverInstance != null) {
            webDriverInstance.manage().deleteCookieNamed("Currency");
            webDriverInstance.manage().addCookie(new Cookie("Currency", currency.getCurrencySymbol()));
        }
    }
}