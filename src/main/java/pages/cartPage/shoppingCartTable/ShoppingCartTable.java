package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.Setter;
import models.CheckoutProductModel;
import models.ProductModel;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.cartPage.BaseTable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class ShoppingCartTable {
    public By cartEmptyMessagePanel = By.xpath("//div[@class='contentpanel']");
    public By cartUpdateButton = By.id("cart_update");
    public By cartCheckoutButton = By.id("cart_checkout1");
    private String xpath = "//div[contains(@class, 'product-list')]/table";
    private BasePage basePage;
    private BaseTable baseTable;

    public ShoppingCartTable() {
        this.basePage = new BasePage();
        this.baseTable = new BaseTable(xpath);
    }

    public List<ProductModel> getProducts() {
        var productCount = countProducts();
        return IntStream.range(1, productCount + 1)
                .mapToObj(this::getProductRow)
                .collect(Collectors.toList());
    }

    public List<CheckoutProductModel> getCheckoutProducts() {
        var productCount = countProducts();
        return IntStream.range(1, productCount + 1)
                .mapToObj(this::getCheckoutProductRow)
                .collect(Collectors.toList());
    }

    public int countProducts() {
        return basePage
                .locateElement(By.xpath(this.xpath))
                .findElements(By.xpath(".//tr"))
                .size() - 1;
    }

    public ProductModel getProductRow(int index) {
        return new ShoppingCartTableRow(index).getProductFromRow();
    }

    public CheckoutProductModel getCheckoutProductRow(int index) {
        return new ShoppingCartTableRow(index).getCheckoutProductFromRow();
    }

    public List<String> getColumnHeaders() {
        return baseTable.getColumnHeaders();
    }

    public int getColumnsCount() {
        return baseTable.getColumnCount();
    }

    public void clickCartUpdateButton() {
        basePage.locateElement(cartUpdateButton).click();
    }

    public void clickCartCheckoutButton() {
        basePage.locateElement(cartCheckoutButton).click();
    }

    public boolean isCartEmpty() {
        var debug = basePage.locateElement(cartEmptyMessagePanel).getText();
        return basePage.locateElement(cartEmptyMessagePanel)
                .getText()
                .contains("Your shopping cart is empty!");
    }
}