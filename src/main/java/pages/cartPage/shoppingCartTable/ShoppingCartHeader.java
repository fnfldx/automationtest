package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static engine.property.manager.PropertyManager.tr;

@Getter
@ToString
@RequiredArgsConstructor
public enum ShoppingCartHeader {
    IMAGE(tr.getString("imageHeader"), 0),
    NAME(tr.getString("nameHeader"), 1),
    MODEL(tr.getString("modelHeader"), 2),
    UNIT_PRICE(tr.getString("unitePriceHeader"), 3),
    QUANTITY(tr.getString("quantityHeader"), 4),
    TOTAL(tr.getString("totalHeader"), 5),
    REMOVE(tr.getString("removeHeader"), 6);

    public final String header;
    public final int columnIndex;
}