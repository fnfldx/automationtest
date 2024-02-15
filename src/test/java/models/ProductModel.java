package models;

import enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductModel {
	public String name;
	public Currency priceCurrency;
	public Double price;
	public String description;
	public String category;
	public Boolean isOnSale;
	public Double priceBeforeSale;
	public Boolean isOutOfStock;
	public String imageUrl;
	public List<String> tags;
}
