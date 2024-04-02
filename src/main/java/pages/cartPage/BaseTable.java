package pages.cartPage;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BaseTable extends BasePage {
    protected String tableXpath;
    public By tableLocator;
    public By headerRow;

    public BaseTable(WebDriver driver, String tableXpath) {
        super(driver);
        this.tableXpath = tableXpath;
        this.headerRow = By.xpath(tableXpath + "/tbody/tr");
        this.tableLocator = By.xpath(tableXpath);
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

    public int getColumnNumber(String columnHeader) {
        int rowIndex = getColumnIndex(columnHeader);
        if (rowIndex == -1) {
            return -1;
        }
        return rowIndex + 1;
    }

    public List<String> getColumnHeaders() {
        WebElement headerRowElement = locateElement(headerRow);
        List<WebElement> headerColumns = headerRowElement.findElements(By.tagName("th"));
        List<String> columnHeaders = new ArrayList<>();
        for (WebElement headerColumn : headerColumns) {
            columnHeaders.add(headerColumn.getText());
        }
        return columnHeaders;
    }
}
