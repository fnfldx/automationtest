package models;

import enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class CheckoutProductModel {
    public final ProductModel productModel;
    public final int quantity;
    public final Currency currencyTotalPrice;
    public final BigDecimal totalPrice;
    public final String removeButtonEndpoint;
}
