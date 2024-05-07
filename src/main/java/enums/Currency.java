package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@Getter
@ToString
@RequiredArgsConstructor
public enum Currency {
    EUR("€"),
    GBP("£"),
    USD("$");

    public final String currencySymbol;

    public static Currency fromSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(currency -> currency.getCurrencySymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant for symbol: " + symbol));
    }
}
