package models;

import enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductModel {
	public final String name;
	public final Currency priceCurrency;
	public final BigDecimal price;
	public final Boolean isOnSale;
	public final BigDecimal priceBeforeSale;
	public final Boolean isOutOfStock;
	public final String imageUrl;
}
