package pages.cartPage.shoppingCartTable;

import enums.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.cartPage.BaseTable;

import java.math.BigDecimal;
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

    public ProductModel getProductFromRow(int rowNumber) {
        var rowContent = getRowContent(rowNumber);
        var name = rowContent.get(ShoppingCartHeader.Name.ordinal());
        var model = rowContent.get(ShoppingCartHeader.Model.ordinal());
        var priceCurrency = getCurrencyFromUnitPrice(rowNumber);
        var price = getUnitPrice(rowNumber);
        var imageUrl = rowContent.get(ShoppingCartHeader.Image.ordinal());

        return ProductModel.builder()
                .name(name)
                .model(model)
                .priceCurrency(priceCurrency)
                .price(price)
                .isOnSale(null)
                .priceBeforeSale(null)
                .isOutOfStock(null)
                .imageUrl(imageUrl)
                .build();
    }

    private String getUnitPriceWithSymbol(int rowNumber) {
        var row = getRowContent(rowNumber);

        return row.get(ShoppingCartHeader.UnitPrice.ordinal());
    }

    public Currency getCurrencyFromUnitPrice(int rowNumber) {
        var row = getRowContent(rowNumber);
        var currencySymbol = row.get(ShoppingCartHeader.UnitPrice.ordinal()).charAt(0);

        return Currency.fromSymbol(String.valueOf(currencySymbol));
    }

    public BigDecimal getUnitPrice(int rowNumber) {
        var unitPriceWithCurrency = getUnitPriceWithSymbol(rowNumber);
        String unitPriceWithoutCurrency = unitPriceWithCurrency.substring(1);
        return new BigDecimal(unitPriceWithoutCurrency);
    }

    public BigDecimal getUnitPrice(String productName) {
        int rowNumber = getRowNumber(productName);
        return getUnitPrice(rowNumber);
    }

    public BigDecimal getUnitPrice(ProductModel product) {
        int rowNumber = getRowNumber(product.getName());
        return getUnitPrice(rowNumber);
    }

    private String getTotalPriceWithCurrencyCharacter(int rowNumber) {
        var row = getRowContent(rowNumber);
        return row.get(ShoppingCartHeader.Total.ordinal());
    }

    public BigDecimal getTotalPrice(int rowNumber) {
        String totalPriceWithCurrency = getTotalPriceWithCurrencyCharacter(rowNumber);
        String totalPriceWithoutCurrency = totalPriceWithCurrency.substring(1);
        return new BigDecimal(totalPriceWithoutCurrency);
    }

    public BigDecimal getTotalPrice(String productName) {
        int rowNumber = getRowNumber(productName);
        return getTotalPrice(rowNumber);
    }

    public BigDecimal getTotalPrice(ProductModel product) {
        int rowNumber = getRowNumber(product.getName());
        return getTotalPrice(rowNumber);
    }

    public void setQuantity(int rowNumber, int quantity) {
        var row = getRow(rowNumber);
        var input = row.findElements(By.tagName("td"))
                .get(ShoppingCartHeader.Quantity.ordinal())
                .findElement(quantityItemInput);

        input.clear();
        input.sendKeys(String.valueOf(quantity));
    }

    public void setQuantity(String productName, int quantity) {
        int rowNumber = getRowNumber(productName);
        setQuantity(rowNumber, quantity);
    }

    public void setQuantity(ProductModel product, int quantity) {
        int rowNumber = getRowNumber(product.getName());
        setQuantity(rowNumber, quantity);
    }

    public void deleteItem(int rowNumber) {
        WebElement row = getRow(rowNumber);
        row.findElement(deleteItemButton).click();
    }

    public void deleteItem(String productName) {
        int rowNumber = getRowNumber(productName);
        deleteItem(rowNumber);
    }

    public void deleteItem(ProductModel product) {
        int rowNumber = getRowNumber(product.getName());
        deleteItem(rowNumber);
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