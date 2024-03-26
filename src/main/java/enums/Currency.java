package enums;

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

	public static Currency fromSymbol(String symbol) {
		for (Currency currency : values()) {
			if (currency.getCurrencySymbol().equals(symbol)) {
				return currency;
			}
		}
		throw new IllegalArgumentException("No enum constant for symbol: " + symbol);
	}
}
