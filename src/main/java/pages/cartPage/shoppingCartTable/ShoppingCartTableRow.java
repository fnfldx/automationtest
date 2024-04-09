package pages.cartPage.shoppingCartTable;

import enums.Currency;
import lombok.Getter;
import lombok.Setter;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.cartPage.BaseTable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

@Getter
@Setter
public class ShoppingCartTableRow {
    public By deleteItemButton = By.xpath(".//i[contains(@class, 'fa-trash-o')]/parent::a");
    public By quantityItemInput = By.xpath(".//input[contains(@id, 'cart_quantity')]");
    protected BasePage basePage;
    protected BaseTable baseTable;
    protected WebDriver driver = getWebDriverInstance();

    public ShoppingCartTableRow() {
        this.baseTable = new BaseTable("//div[contains(@class, 'product-list')]/table");
        this.basePage = baseTable.getBasePage();
    }

    public ProductModel getProductFromRow(int rowNumber) {
        var rowContent = getRowContent(rowNumber);

        return ProductModel.builder()
                .name(rowContent.get(ShoppingCartHeader.NAME.columnIndex))
                .model(rowContent.get(ShoppingCartHeader.MODEL.columnIndex))
                .priceCurrency(getCurrencyFromUnitPrice(rowNumber))
                .price(getUnitPrice(rowNumber))
                .imageUrl(rowContent.get(ShoppingCartHeader.IMAGE.columnIndex))
                .build();
    }

    public List<String> getRowContent(int rowNumber) {
        var cells = getRow(rowNumber).findElements(By.tagName("td"));
        List<String> cellData = new ArrayList<>();

        if (cells.size() == 7) {
            cellData.add(getImageItemSrc(cells.get(ShoppingCartHeader.IMAGE.columnIndex)));
            cellData.add(cells.get(ShoppingCartHeader.NAME.columnIndex).getText());
            cellData.add(cells.get(ShoppingCartHeader.MODEL.columnIndex).getText());
            cellData.add(cells.get(ShoppingCartHeader.UNIT_PRICE.columnIndex).getText());
            cellData.add(getQuantityInputValue(cells.get(ShoppingCartHeader.QUANTITY.columnIndex)));
            cellData.add(cells.get(ShoppingCartHeader.TOTAL.columnIndex).getText());
            cellData.add(getDeleteButtonHref(cells.get(ShoppingCartHeader.REMOVE.columnIndex)));
        } else {
            throw new IllegalArgumentException("Row does not contain 7 cells");
        }
        return cellData;
    }

    public Currency getCurrencyFromUnitPrice(int rowNumber) {
        var row = getRowContent(rowNumber);
        var currencySymbol = row.get(ShoppingCartHeader.UNIT_PRICE.columnIndex).charAt(0);
        return Currency.fromSymbol(String.valueOf(currencySymbol));
    }

    public Currency getCurrencyFromTotalPrice(int rowNumber) {
        var row = getRowContent(rowNumber);
        var currencySymbol = row.get(ShoppingCartHeader.TOTAL.columnIndex).charAt(0);
        return Currency.fromSymbol(String.valueOf(currencySymbol));
    }

    public BigDecimal getUnitPrice(int rowNumber) {
        var row = getRowContent(rowNumber).get(ShoppingCartHeader.UNIT_PRICE.columnIndex);
        return new BigDecimal(row.substring(1));
    }

    public BigDecimal getUnitPrice(String productName) {
        int rowNumber = getRowNumber(productName);
        return getUnitPrice(rowNumber);
    }

    public BigDecimal getUnitPrice(ProductModel product) {
        int rowNumber = getRowNumber(product.getName());
        return getUnitPrice(rowNumber);
    }

    public BigDecimal getTotalPrice(int rowNumber) {
        var row = getRowContent(rowNumber).get(ShoppingCartHeader.TOTAL.columnIndex);
        return new BigDecimal(row.substring(1));
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
                .get(ShoppingCartHeader.QUANTITY.columnIndex)
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

    public int getQuantity(int rowNumber) {
        return Integer.parseInt(getQuantityInputValue(getRow(rowNumber)));
    }

    public int getQuantity(String productName) {
        int rowNumber = getRowNumber(productName);
        return getQuantity(rowNumber);
    }

    public int getQuantity(ProductModel product) {
        int rowNumber = getRowNumber(product.getName());
        return getQuantity(rowNumber);
    }

    private String getQuantityInputValue(WebElement cell) {
        return cell.findElements(quantityItemInput).getFirst().getAttribute("value");
    }

    private String getImageItemSrc(WebElement cell) {
        return cell.findElements(By.xpath(".//img")).getFirst().getAttribute("src");
    }

    private String getDeleteButtonHref(WebElement cell) {
        return cell.findElement(By.xpath("./a")).getAttribute("href");
    }

    public void deleteProduct(int rowNumber) {
        WebElement row = getRow(rowNumber);
        row.findElement(deleteItemButton).click();
    }

    public void deleteProduct(String productName) {
        int rowNumber = getRowNumber(productName);
        deleteProduct(rowNumber);
    }

    public void deleteProduct(ProductModel product) {
        int rowNumber = getRowNumber(product.getName());
        deleteProduct(rowNumber);
    }

    private List<WebElement> getTableRows() {
        var table = basePage.locateElement(baseTable.tableLocator);
        return table.findElements(By.tagName("tr"));
    }

    private WebElement getRow(int rowNumber) {
        validateRowNumber(rowNumber);
        var rows = getTableRows();
        return rows.get(rowNumber - 1);
    }

    private void validateRowNumber(int rowNumber) {
        if (rowNumber == 1) {
            throw new IllegalArgumentException("Row number 1 is a header row, not valid for this operation");
        }
    }

    public int getRowNumber(String text) {
        int rowIndex = getRowIndex(text);
        return (rowIndex == -1) ? -1 : rowIndex + 1;
    }

    public int getRowIndex(String text) {
        var rows = getTableRows();
        int index = 0;

        for (var row : rows) {
            if (row.getText().contains(text)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
