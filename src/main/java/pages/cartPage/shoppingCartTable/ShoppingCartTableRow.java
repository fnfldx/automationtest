package pages.cartPage.shoppingCartTable;

import enums.Currency;
import lombok.Getter;
import lombok.Setter;
import models.CheckoutProductModel;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.math.BigDecimal;
import java.util.List;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

@Getter
@Setter
public class ShoppingCartTableRow {
    public By deleteItemButton = By.xpath(".//i[contains(@class, 'fa-trash-o')]/parent::a");
    public By quantityItemInput = By.xpath(".//input[contains(@id, 'cart_quantity')]");
    protected WebDriver driver = getWebDriverInstance();
    private String xpath;
    private BasePage basePage;

    public ShoppingCartTableRow(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("First row is header");
        }
        this.xpath = String.format("//div[contains(@class, 'product-list')]/table/tbody/tr[%s]", index + 1);
        this.basePage = new BasePage();
    }

    public List<WebElement> getCells() {
        return basePage.locateElement(By.xpath(this.xpath))
                .findElements(By.xpath("./td"));
    }

    public CheckoutProductModel getCheckoutProductFromRow() {
        var productModel = getProductFromRow();
        return CheckoutProductModel.builder()
                .productModel(productModel)
                .quantity(getQuantity())
                .currencyTotalPrice(getCurrencyFromTotalPrice())
                .totalPrice(getTotalPrice())
                .removeButtonEndpoint(getDeleteButtonEndpoint())
                .build();
    }

    public ProductModel getProductFromRow() {
        return ProductModel.builder()
                .name(getName())
                .model(getModel())
                .priceCurrency(getCurrencyFromUnitPrice())
                .price(getUnitPrice())
                .imageUrl(getImageProductSrc())
                .build();
    }

    public String getName() {
        return getCells()
                .get(ShoppingCartHeader.NAME.columnIndex)
                .getText();
    }

    public String getModel() {
        return getCells()
                .get(ShoppingCartHeader.MODEL.columnIndex)
                .getText();
    }

    public Currency getCurrencyFromUnitPrice() {
        var currencySymbol = getCells()
                .get(ShoppingCartHeader.UNIT_PRICE.columnIndex)
                .getText()
                .charAt(0);
        return Currency.fromSymbol(String.valueOf(currencySymbol));
    }

    public Currency getCurrencyFromTotalPrice() {
        var currencySymbol = getCells()
                .get(ShoppingCartHeader.TOTAL.columnIndex)
                .getText()
                .charAt(0);
        return Currency.fromSymbol(String.valueOf(currencySymbol));
    }

    public BigDecimal getUnitPrice() {
        var price = getCells()
                .get(ShoppingCartHeader.UNIT_PRICE.columnIndex)
                .getText();
        return new BigDecimal(price.substring(1));
    }

    public BigDecimal getTotalPrice() {
        var price = getCells()
                .get(ShoppingCartHeader.TOTAL.columnIndex)
                .getText();
        return new BigDecimal(price.substring(1));
    }

    public int getQuantity() {
        return Integer.parseInt(getCells()
                .get(ShoppingCartHeader.QUANTITY.columnIndex)
                .findElement(quantityItemInput)
                .getAttribute("value"));
    }

    public void setQuantity(int quantity) {
        var row = getCells();
        var input = row.get(ShoppingCartHeader.QUANTITY.columnIndex)
                .findElement(quantityItemInput);
        input.clear();
        input.sendKeys(String.valueOf(quantity));
    }

    public String getImageProductSrc() {
        return getCells()
                .get(ShoppingCartHeader.IMAGE.columnIndex)
                .findElement(By.xpath(".//img"))
                .getAttribute("src");
    }

    public String getDeleteButtonEndpoint() {
        return getCells()
                .get(ShoppingCartHeader.REMOVE.columnIndex)
                .findElement(deleteItemButton)
                .getAttribute("href");
    }

    public void removeProduct() {
        basePage.locateElement(By.xpath(this.xpath))
                .findElement(deleteItemButton).click();
    }
}