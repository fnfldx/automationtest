package pages.cartPage;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BaseTable {
    protected BasePage basePage;
    public String tableXpath;
    public By tableLocator;
    public By headerRow;

    public BaseTable(String tableXpath) {
        this.basePage = new BasePage();
        this.tableXpath = tableXpath;
        this.headerRow = By.xpath(tableXpath + "/tbody/tr");
        this.tableLocator = By.xpath(tableXpath);
    }

    public int getRowCount() {
        return basePage.locateElement(tableLocator)
                .findElements(By.tagName("tr"))
                .size();
    }

    public int getColumnCount() {
        return basePage.locateElement(headerRow)
                .findElements(By.tagName("th"))
                .size();
    }

    public int getColumnIndex(String columnHeader) {
        return getColumnHeaders().indexOf(columnHeader);
    }

    public int getColumnNumber(String columnHeader) {
        int rowIndex = getColumnIndex(columnHeader);
        return (rowIndex == -1) ? -1 : rowIndex + 1;
    }

    public List<String> getColumnHeaders() {
        return basePage.locateElement(headerRow)
                .findElements(By.tagName("th"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
