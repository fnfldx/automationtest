package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum CategoryMenuButton {
	HOME("Home"),
	APPAREL_AND_ACCESSORIES("Apparel & accessories"),
	MAKEUP("Makeup"),
	SKINCARE("Skincare"),
	FRAGRANCE("Fragrance"),
	MEN("Men"),
	HAIR_CARE("Hair Care"),
	BOOKS("Books");

	private final String text;
}