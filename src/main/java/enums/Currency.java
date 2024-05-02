package enums;

import engine.cookie.manager.CookieManager;
import engine.property.manager.PropertyManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

import static engine.cookie.manager.CookieManager.getGlobalCurrency;

@Getter
@ToString
@RequiredArgsConstructor
public enum Currency {
    EUR("€"),
    GBP("£"),
    USD("$");

    public final String currencySymbol;

    public static BigDecimal convertCurrency(String priceWithSymbol) {
        var globalCurrencySymbol = getGlobalCurrency().getCurrencySymbol();
        return new BigDecimal(priceWithSymbol
                .replace(globalCurrencySymbol, ""));
    }
}
