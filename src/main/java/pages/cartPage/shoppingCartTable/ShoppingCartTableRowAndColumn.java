package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.Setter;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.cartPage.BaseTable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

@Getter
@Setter
public class ShoppingCartTableRowAndColumn {
    protected BaseTable baseTable;
    protected WebDriver driver = getWebDriverInstance();
    public By deleteItemButton = By.xpath(".//i[contains(@class, 'fa-trash-o')]/parent::a");
    public By quantityItemInput = By.xpath(".//input[contains(@id, 'cart_quantity')]");

    public ShoppingCartTableRowAndColumn() {
        this.baseTable = new BaseTable("//div[contains(@class, 'product-list')]/table");
    }

    public int getRowNumber(String text) {
        int rowIndex = getRowIndex(text);
        if (rowIndex == -1) {
            return -1;
        }
        return rowIndex + 1;
    }

    protected WebElement getRow(int rowNumber) {
        if (rowNumber == 1) {
            throw new IllegalArgumentException("Row number 1 is a header row, not valid for this operation");
        }
        WebElement table = baseTable.locateElement(baseTable.tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        if (rowNumber > 0 && rowNumber < rows.size()) {
            return rows.get(rowNumber - 1);
        } else {
            throw new IllegalArgumentException("Row number [" + rowNumber + "] is out of range");
        }
    }

    protected WebElement getCell(int rowNumber, int columnNumber) {
        if (rowNumber == 1) {
            throw new IllegalArgumentException("Row number 1 is a header row, not valid for this operation");
        }
        List<WebElement> productRows = driver.findElements(By.xpath(baseTable.tableXpath + "//tr[.//td]"));

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

    public int getRowIndex(String text) {
        WebElement table = baseTable.locateElement(baseTable.tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (row.getText().contains(text)) {
                return i;
            }
        }
        return -1;
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
        List<WebElement> rows = driver.findElements(By.xpath(baseTable.tableXpath + "//tr[.//td]"));

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
        List<String> columnHeaders = baseTable.getColumnHeaders();
        int columnIndex = columnHeaders.indexOf(columnName);
        return getColumnContent(columnIndex + 1);
    }

    public String getCellContent(int rowNumber, int columnNumber) {
        WebElement cell = getCell(rowNumber, columnNumber);
        return getCellContent(cell);
    }

    public String getCellContent(int rowNumber, String columnName) {
        List<String> columnHeaders = baseTable.getColumnHeaders();
        int columnIndex = columnHeaders.indexOf(columnName);
        return getCellContent(rowNumber, columnIndex + 1);
    }

    public int getQuantity(int rowNumber) {
        String quantity = getCellContent(rowNumber, baseTable.getColumnNumber("Quantity"));
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
}
