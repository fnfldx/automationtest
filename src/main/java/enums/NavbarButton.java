package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum NavbarButton {
	SPECIALS("menu_specials"),
	ACCOUNT("menu_account"),
	CART("menu_cart"),
	CHECKOUT("menu_checkout");

	private final String dataId;
}
