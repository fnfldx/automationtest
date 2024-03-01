package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTable extends BasePage implements BaseTable{
    private final String tableXpath = "//div[contains(@class, 'product-list')]/table";

    public By tableLocator = By.xpath(tableXpath);
    public By cartEmptyMessagePanel = By.xpath("//div[@class='contentpanel1']");
    public By headerRow = By.xpath(tableXpath + "/tbody/tr");
    public By deleteItemButton = By.xpath("//i[contains(@class, 'fa-trash-o')]/parent::a");
    public By quantityItemInput = By.xpath("//input[contains(@id, 'cart_quantity')]");
    public By imageItem = By.xpath(tableXpath + "//img");
    public By cartUpdateButton = By.id("cart_update");
    public By cartCheckoutButton = By.id("cart_checkout1");

    public ShoppingCartTable(WebDriver driver) {
        super(driver);
    }

    public int getRowCount() {
        WebElement table = locateElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    }

    public int getColumnCount() {
        WebElement headerRowElement = locateElement(headerRow);
        List<WebElement> headerColumns = headerRowElement.findElements(By.tagName("th"));
        return headerColumns.size();
    }

    public int getColumnIndex(String columnHeader) {
        List<String> columnHeaders = getColumnHeaders();
        return columnHeaders.indexOf(columnHeader);
    }

    public List<String> getColumnHeaders() {
        WebElement headerRowElement = locateElement(headerRow);
        List<WebElement> headerColumns = headerRowElement.findElements(By.tagName("th"));

        List<String> headerTexts = new ArrayList<>();
        for(WebElement headerColumn : headerColumns) {
            headerTexts.add(headerColumn.getText());
        }
        return headerTexts;
    }

    public List<String> getRowContent(int rowNumber) {
        WebElement table = locateElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        if (rowNumber > 0 && rowNumber < rows.size()) {
            WebElement targetRow = rows.get(rowNumber);
            List<WebElement> cells = targetRow.findElements(By.tagName("td"));

            List<String> rowData = new ArrayList<>();
            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }
            return rowData;
        }
        else {
            throw new IllegalArgumentException("Row number ["+ rowNumber + "] is out of range");
        }
    }

    public List<String> getColumnContent(int columnNumber) {
        List<WebElement> rows = driver.findElements(By.xpath(tableXpath + "//tr[.//td]"));

        List<String> columnData = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if (columnNumber > 0 && columnNumber <= cells.size()) {
                columnData.add(cells.get(columnNumber - 1).getText());
            }
            else {
                throw new IllegalArgumentException("Column number ["+ columnNumber + "] is out of range");
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
        List<WebElement> rows = driver.findElements(By.xpath(tableXpath + "//tr[.//td]"));

        if (rowNumber > 0 && rowNumber <= rows.size()) {
            WebElement targetRow = rows.get(rowNumber - 1);
            List<WebElement> cells = targetRow.findElements(By.tagName("td"));

            if (columnNumber > 0 && columnNumber <= cells.size()) {
                return cells.get(columnNumber - 1).getText();
            }
            else {
                throw new IllegalArgumentException("Column number ["+ columnNumber + "] is out of range");
            }
        }
        else {
            throw new IllegalArgumentException("Row number ["+ rowNumber + "] is out of range");
        }
    }

    public String getCellContent(int rowNumber, String columnName) {
        List<String> columnHeaders = getColumnHeaders();
        int columnIndex = columnHeaders.indexOf(columnName);
        return getCellContent(rowNumber, columnIndex + 1);
    }
}