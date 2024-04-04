package pages.cartPage.shoppingCartTable;

import enums.Currency;
import lombok.Getter;
import lombok.Setter;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.cartPage.BaseTable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShoppingCartTable extends ShoppingCartTableRowAndColumn {
    public By cartEmptyMessagePanel = By.xpath("//div[@class='contentpanel1']");
    public By cartUpdateButton = By.id("cart_update");
    public By cartCheckoutButton = By.id("cart_checkout1");

    public ShoppingCartTable() {
        this.baseTable = new BaseTable("//div[contains(@class, 'product-list')]/table");
    }

    public List<ProductModel> getProducts() {
        List<ProductModel> products = new ArrayList<>();
        int rowCount = baseTable.getRowCount();

        for (int i = 2; i <= rowCount; i++) {
            products.add(createProductFromRow(i));
        }

        return products;
    }

    private ProductModel createProductFromRow(int rowNumber)
    {
        String imageUrl = getCellContent(rowNumber, baseTable.getColumnNumber(ShoppingCartHeader.Image.getHeader()));
        String name = getCellContent(rowNumber, baseTable.getColumnNumber(ShoppingCartHeader.Name.getHeader()));
        String model = getCellContent(rowNumber, baseTable.getColumnNumber(ShoppingCartHeader.Model.getHeader()));
        Currency currency = getCurrency();
        BigDecimal unitPrice = getUnitPrice(rowNumber);

        return new ProductModel(name, model, currency, unitPrice, null, null, null, imageUrl);
    }

    public String getUnitPriceWithCurrencyCharacter(int rowNumber) {
        return getCellContent(rowNumber, baseTable.getColumnNumber(ShoppingCartHeader.UnitPrice.getHeader()));
    }

    public Currency getCurrency() {
        char currencySymbol = getUnitPriceWithCurrencyCharacter(2).charAt(0);
        return Currency.fromSymbol(String.valueOf(currencySymbol));
    }

    public BigDecimal getUnitPrice(int rowNumber) {
        String unitPriceWithCurrency = getUnitPriceWithCurrencyCharacter(rowNumber);
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

    public String getTotalPriceWithCurrencyCharacter(int rowNumber) {
        return getCellContent(rowNumber, baseTable.getColumnNumber(ShoppingCartHeader.Total.getHeader()));
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
        WebElement cell = getCell(rowNumber, baseTable.getColumnNumber(ShoppingCartHeader.Quantity.getHeader()));
        WebElement input = cell.findElement(quantityItemInput);
        input.clear();
        input.sendKeys(String.valueOf(quantity));
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
        baseTable.locateElement(cartUpdateButton).click();
    }

    public void clickCartCheckoutButton() {
        baseTable.locateElement(cartCheckoutButton).click();
    }

    public boolean isCartEmpty() {
        return baseTable.isElementDisplayed(cartEmptyMessagePanel);
    }
}