package enums;

import engine.property.manager.PropertyManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum Currency {
    EUR("€"),
    GBP("£"),
    USD("$");

    public final String currencySymbol;

    public static void setGlobalCurrency(Currency currency) {
        PropertyManager.setProperty("CURRENCY", currency.name());
    }
}
