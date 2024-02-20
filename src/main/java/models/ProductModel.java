package models;

import enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductModel {
	public final String name;
	public final Currency priceCurrency;
	public final Double price;
	public final Boolean isOnSale;
	public final Double priceBeforeSale;
	public final Boolean isOutOfStock;
	public final String imageUrl;
}
