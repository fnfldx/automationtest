package pages.cartPage;

import enums.Currency;
import lombok.Getter;
import lombok.Setter;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShoppingCartTable extends BaseTable {
    public By cartEmptyMessagePanel = By.xpath("//div[@class='contentpanel1']");
    public By deleteItemButton = By.xpath(".//i[contains(@class, 'fa-trash-o')]/parent::a");
    public By quantityItemInput = By.xpath(".//input[contains(@id, 'cart_quantity')]");
    public By cartUpdateButton = By.id("cart_update");
    public By cartCheckoutButton = By.id("cart_checkout1");

    public ShoppingCartTable(WebDriver driver) {
        super(driver, "//div[contains(@class, 'product-list')]/table");
    }

    public List<ProductModel> getProducts() {
        List<ProductModel> products = new ArrayList<>();
        int imageNumber = getColumnNumber("Image");
        int nameNumber = getColumnNumber("Name");
        int modelNumber = getColumnNumber("Model");
        int unitPriceNumber = getColumnNumber("Unit Price");

        int rowCount = getRowCount();
        for (int i = 2; i <= rowCount; i++) {
            String imageUrl = getCellContent(i, imageNumber);
            String name = getCellContent(i , nameNumber);
            String model = getCellContent(i , modelNumber);
            Currency currency = getCurrency();
            BigDecimal unitPrice = getUnitPrice(i);

            ProductModel product = new ProductModel
                    (
                            name,
                            model,
                            currency,
                            unitPrice,
                            null,
                            null,
                            null,
                            imageUrl
                    );
            products.add(product);
        }
        return products;
    }

    public int getRowIndex(String text) {
        WebElement table = locateElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (row.getText().contains(text)) {
                return i;
            }
        }
        return -1;
    }

    public int getRowNumber(String text) {
        int rowIndex = getRowIndex(text);
        if (rowIndex == -1) {
            return -1;
        }
        return rowIndex + 1;
    }

    private WebElement getRow(int rowNumber) {
        if (rowNumber == 1) {
            throw new IllegalArgumentException("Row number 1 is a header row, not valid for this operation");
        }
        WebElement table = locateElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        if (rowNumber > 0 && rowNumber < rows.size()) {
            return rows.get(rowNumber - 1);
        } else {
            throw new IllegalArgumentException("Row number [" + rowNumber + "] is out of range");
        }
    }

    private WebElement getCell(int rowNumber, int columnNumber) {
        if (rowNumber == 1) {
            throw new IllegalArgumentException("Row number 1 is a header row, not valid for this operation");
        }
        List<WebElement> productRows = driver.findElements(By.xpath(tableXpath + "//tr[.//td]"));

        if (rowNumber > 0 && rowNumber <= productRows.size() + 1) {
            WebElement targetRow = productRows.get(rowNumber - 2);
            List<WebElement> cells = targetRow.findElements(By.tagName("td"));

            if (columnNumber > 0 && columnNumber <= cells.size()) {
                return cells.get(columnNumber - 1);
            } else {
                throw new IllegalArgumentException("Column number [" + columnNumber + "] is out of range");
            }
        } else {
            throw new IllegalArgumentException("Row number [" + rowNumber + "] is out of range");
        }
    }

    private String getCellContent(WebElement cell) {
        if (hasQuantityInput(cell)) {
            return getQuantityInputValue(cell);
        } else if (hasImageItem(cell)) {
            return getImageItemSrc(cell);
        } else if (hasDeleteButton(cell)) {
            return getDeleteButtonHref(cell);
        } else {
            return cell.getText();
        }
    }

    private boolean hasQuantityInput(WebElement cell) {
        return !cell.findElements(quantityItemInput).isEmpty();
    }

    private String getQuantityInputValue(WebElement cell) {
        return cell.findElements(quantityItemInput).getFirst().getAttribute("value");
    }

    private boolean hasImageItem(WebElement cell) {
        return !cell.findElements(By.xpath(".//img")).isEmpty();
    }

    private String getImageItemSrc(WebElement cell) {
        return cell.findElements(By.xpath(".//img")).getFirst().getAttribute("src");
    }

    private boolean hasDeleteButton(WebElement cell) {
        return !cell.findElements(deleteItemButton).isEmpty();
    }

    private String getDeleteButtonHref(WebElement cell) {
        return cell.findElement(By.xpath("./a")).getAttribute("href");
    }

    public List<String> getRowContent(int rowNumber) {
        WebElement row = getRow(rowNumber);
        List<WebElement> cells = row.findElements(By.tagName("td"));

        List<String> cellData = new ArrayList<>();
        for (WebElement cell : cells) {
            cellData.add(getCellContent(cell));
        }
        return cellData;
    }

    public List<String> getColumnContent(int columnNumber) {
        List<WebElement> rows = driver.findElements(By.xpath(tableXpath + "//tr[.//td]"));

        List<String> columnData = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if (columnNumber > 0 && columnNumber <= cells.size()) {
                columnData.add(getCellContent(cells.get(columnNumber - 1)));
            } else {
                throw new IllegalArgumentException("Column number [" + columnNumber + "] is out of range");
            }
        }
        return columnData;
    }

    public List<String> getColumnContent(String columnName) {
        List<String> columnHeaders = getColumnHeaders();
        int columnIndex = columnHeaders.indexOf(columnName);
        return getColumnContent(columnIndex + 1);
    }

    public String getCellContent(int rowNumber, int columnNumber) {
        WebElement cell = getCell(rowNumber, columnNumber);
        return getCellContent(cell);
    }

    public String getCellContent(int rowNumber, String columnName) {
        List<String> columnHeaders = getColumnHeaders();
        int columnIndex = columnHeaders.indexOf(columnName);
        return getCellContent(rowNumber, columnIndex + 1);
    }

    public String getUnitPriceWithCurrencyCharacter(int rowNumber) {
        return getCellContent(rowNumber, getColumnNumber("Unit Price"));
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
        return getCellContent(rowNumber, getColumnNumber("Total Price"));
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

    public int getQuantity(int rowNumber) {
        String quantity = getCellContent(rowNumber, getColumnNumber("Quantity"));
        return Integer.parseInt(quantity);
    }

    public int getQuantity(String productName) {
        int rowNumber = getRowNumber(productName);
        return getQuantity(rowNumber);
    }

    public int getQuantity(ProductModel product) {
        int rowNumber = getRowNumber(product.getName());
        return getQuantity(rowNumber);
    }

    public void setQuantity(int rowNumber, int quantity) {
        WebElement cell = getCell(rowNumber, getColumnNumber("Quantity"));
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
        locateElement(cartUpdateButton).click();
    }

    public void clickCartCheckoutButton() {
        locateElement(cartCheckoutButton).click();
    }

    public boolean isCartEmpty() {
        return isElementDisplayed(cartEmptyMessagePanel);
    }
}