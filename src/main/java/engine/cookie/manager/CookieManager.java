package engine.cookie.manager;

import enums.Currency;
import lombok.Getter;
import org.openqa.selenium.Cookie;

import java.util.HashSet;
import java.util.Set;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.property.manager.PropertyManager.getCookiesFromProperty;


@Getter
public class CookieManager {
    private static final String sessionCookieName = "AC_SF_8CEFDA09D5";
    private static CookieManager cookieManagerInstance;
    private static Set<Cookie> cookies = new HashSet<>();

    public CookieManager() {
        cookies.addAll(getWebDriverInstance().manage().getCookies());
    }

    public static synchronized CookieManager getCookieManagerInstance() {
        if (cookieManagerInstance == null) {
            cookieManagerInstance = new CookieManager();
        }
        return cookieManagerInstance;
    }

    public static void clearCookies() {
        getWebDriverInstance().manage().deleteAllCookies();
        cookies.clear();
    }

    public static void setCookiesFromProperties() {
        var cookiesFromProperty = getCookiesFromProperty();
        for (Cookie cookie : cookiesFromProperty) {
            if (!cookies.contains(cookie)) {
                addCookie(cookie);
            } else {
                removeCookie(cookie);
                addCookie(cookie);
            }
        }
        findAndRemoveCookie(sessionCookieName); //to refresh new settings session cookie has to be removed
        getWebDriverInstance().navigate().refresh();
        cookies.add(findCookie(sessionCookieName));
    }

    public static void setGlobalCurrency(Currency currency) {
        findAndRemoveCookie("currency");
        findAndRemoveCookie(sessionCookieName);
        addCookie(new Cookie("currency", currency.name()));
        getWebDriverInstance().navigate().refresh();
        cookies.add(findCookie(sessionCookieName));
    }

    private static void addCookie(Cookie cookie) {
        getWebDriverInstance().manage().addCookie(cookie);
        cookies.add(cookie);
    }

    private static void removeCookie(Cookie cookie) {
        getWebDriverInstance().manage().deleteCookie(cookie);
        cookies.remove(cookie);
    }

    private static Cookie findCookie(String name) {
        return getWebDriverInstance().manage().getCookieNamed(name);
    }

    private static void findAndRemoveCookie(String name) {
        var cookie = findCookie(name);
        if (cookie != null) {
            removeCookie(cookie);
        }
    }
}