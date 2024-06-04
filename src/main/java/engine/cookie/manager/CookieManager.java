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
    public static final String CURRENCY_COOKIE_NAME = "currency";
    private static final String SESSION_COOKIE_NAME = "AC_SF_8CEFDA09D5";
    private static CookieManager cookieManagerInstance;
    public Currency globalCurrency;
    private Set<Cookie> cookies = new HashSet<>();

    public CookieManager() {
        cookies.addAll(getWebDriverInstance().manage().getCookies());
        globalCurrency = getGlobalCurrency();
    }

    public static synchronized CookieManager getCookieManagerInstance() {
        if (cookieManagerInstance == null) {
            cookieManagerInstance = new CookieManager();
        }
        return cookieManagerInstance;
    }

    public void clearCookies() {
        getWebDriverInstance().manage().deleteAllCookies();
        this.cookies.clear();
    }

    public void setCookiesFromProperties() {
        var cookiesFromProperty = getCookiesFromProperty();
        for (Cookie cookie : cookiesFromProperty) {
            addCookie(cookie);
            if (cookie.getName().equals(CURRENCY_COOKIE_NAME)) {
                globalCurrency = Currency.valueOf(cookie.getValue());
            }
        }
        updateSessionCookie();
    }

    private void updateSessionCookie() {
        findAndRemoveCookie(SESSION_COOKIE_NAME);
        getWebDriverInstance().navigate().refresh();
        cookies.add(findCookie(SESSION_COOKIE_NAME));
    }

    private void addCookie(Cookie cookie) {
        findAndRemoveCookie(SESSION_COOKIE_NAME);
        if (this.cookies.contains(cookie)) {
            removeCookie(cookie);
        }
        getWebDriverInstance().manage().addCookie(cookie);
        this.cookies.add(cookie);
    }

    private void removeCookie(Cookie cookie) {
        getWebDriverInstance().manage().deleteCookie(cookie);
        this.cookies.remove(cookie);
    }

    private Cookie findCookie(String name) {
        return getWebDriverInstance().manage().getCookieNamed(name);
    }

    private void findAndRemoveCookie(String name) {
        var cookie = findCookie(name);
        if (cookie != null) {
            removeCookie(cookie);
        }
    }

    private Currency getGlobalCurrency() {
        return Currency.valueOf(findCookie(CURRENCY_COOKIE_NAME).getValue());
    }

    public void setGlobalCurrency(Currency currency) {
        findAndRemoveCookie(CURRENCY_COOKIE_NAME);
        addCookie(new Cookie(CURRENCY_COOKIE_NAME, currency.name()));
        updateSessionCookie();
        globalCurrency = currency;
    }
}