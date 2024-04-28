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
        cookies.add(new Cookie("currency", getCurrency().name()));
    }

    public void setGlobalCurrency(Currency currency) {
        cookies.removeIf(cookie -> cookie.getName().equals("AC_SF_8CEFDA09D5"));
        cookies.removeIf(cookie -> cookie.getName().equals("currency"));
        cookies.add(new Cookie("currency", currency.name()));
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