package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum ShoppingCartHeader {
    Image("Image"),
    Name("Name"),
    Model("Model"),
    UnitPrice("Unit Price"),
    Quantity("Quantity"),
    Total("Total"),
    Remove("Remove");

    public final String header;
}
