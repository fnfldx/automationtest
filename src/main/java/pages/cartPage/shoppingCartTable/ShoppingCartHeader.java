package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum ShoppingCartHeader {
    IMAGE("Image",0),
    NAME("Name",1),
    MODEL("Model",2),
    UNIT_PRICE("Unit Price",3),
    QUANTITY("Quantity",4),
    TOTAL("Total",5),
    REMOVE("Remove",6);

    public final String header;
    public final int columnIndex;
}
