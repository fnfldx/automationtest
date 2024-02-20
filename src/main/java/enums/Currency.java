package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum Currency {
	EUR("€"),
	GBP("£"),
	USD("$");

	public final String currencySymbol;
}
