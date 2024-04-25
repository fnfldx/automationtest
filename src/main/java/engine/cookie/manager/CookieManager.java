package engine.cookie.manager;

import lombok.Getter;
import org.openqa.selenium.Cookie;
import enums.Currency;

import java.util.HashSet;
import java.util.Set;

import static engine.property.manager.PropertyManager.getCurrency;

@Getter
public class CookieManager {
    private static CookieManager cookieManagerInstance;
    private static Set<Cookie> cookies;

    public static synchronized CookieManager getCookieManagerInstance() {
        if (cookieManagerInstance == null) {
            cookieManagerInstance = new CookieManager();
        }
        return cookieManagerInstance;
    }

    private CookieManager() {
        cookies = new HashSet<>();
        cookies.add(new Cookie("Currency", getCurrency().currencySymbol));
    }

    public void setGlobalCurrency(Currency currency) {
        cookies.removeIf(cookie -> cookie.getName().equals("Currency"));
        cookies.add(new Cookie("Currency", currency.getCurrencySymbol()));
    }

    public Set<Cookie> getCookies() {
        return cookies;
    }

    public static void clearCookies() {
        cookies.clear();
    }

    public void addCookie(Cookie cookie) {
        cookies.add(cookie);
    }

    public void removeCookie(Cookie cookie) {
        cookies.remove(cookie);
    }
}