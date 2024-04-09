package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.ProductModel;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingCartTable extends ShoppingCartTableRow {
    public By cartEmptyMessagePanel = By.xpath("//div[@class='contentpanel1']");
    public By cartUpdateButton = By.id("cart_update");
    public By cartCheckoutButton = By.id("cart_checkout1");

    public List<ProductModel> getProducts() {
        int rowCount = baseTable.getRowCount();

        return IntStream.range(2, rowCount + 1)
                .mapToObj(this::getProductFromRow)
                .collect(Collectors.toList());
    }

    public int countProducts() {
        return baseTable.getRowCount() - 1;
    }

    public void clickCartUpdateButton() {
        basePage.locateElement(cartUpdateButton).click();
    }

    public void clickCartCheckoutButton() {
        basePage.locateElement(cartCheckoutButton).click();
    }

    public boolean isCartEmpty() {
        return basePage.isElementDisplayed(cartEmptyMessagePanel);
    }
}