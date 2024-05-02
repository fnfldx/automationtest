package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

import static engine.cookie.manager.CookieManager.getCookieManagerInstance;

@Getter
@ToString
@RequiredArgsConstructor
public enum Currency {
    EUR("€"),
    GBP("£"),
    USD("$");

    public final String currencySymbol;

    public static BigDecimal convertCurrency(String priceWithSymbol, Currency currency) {
        var currencySymbol = currency.getCurrencySymbol();
        return new BigDecimal(priceWithSymbol
                .replace(currencySymbol, ""));
    }

    public static BigDecimal convertCurrencyFromCookie(String priceWithSymbol) {
        return convertCurrency(priceWithSymbol, getCookieManagerInstance().globalCurrency);
    }
}