package pages.cartPage.shoppingCartTable;

import lombok.Getter;
import lombok.Setter;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.cartPage.BaseTable;

import java.util.ArrayList;
import java.util.List;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

@Getter
@Setter
public class ShoppingCartTableRow {
    protected BasePage basePage;
    protected BaseTable baseTable;
    protected WebDriver driver = getWebDriverInstance();
    public By deleteItemButton = By.xpath(".//i[contains(@class, 'fa-trash-o')]/parent::a");
    public By quantityItemInput = By.xpath(".//input[contains(@id, 'cart_quantity')]");

    public ShoppingCartTableRow() {
        this.baseTable = new BaseTable("//div[contains(@class, 'product-list')]/table");
        this.basePage = baseTable.getBasePage();
    }

    public int getRowNumber(String text) {
        int rowIndex = getRowIndex(text);
        return (rowIndex == -1) ? -1 : rowIndex + 1;
    }

    protected void validateRowNumber(int rowNumber) {
        if (rowNumber == 1) {
            throw new IllegalArgumentException("Row number 1 is a header row, not valid for this operation");
        }
    }

    protected List<WebElement> getTableRows() {
        var table = basePage.locateElement(baseTable.tableLocator);
        return table.findElements(By.tagName("tr"));
    }

    protected WebElement getRow(int rowNumber) {
        validateRowNumber(rowNumber);
        var rows = getTableRows();
        return rows.get(rowNumber - 1);
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

    public List<String> getRowContent(int rowNumber) {
        var row = getRow(rowNumber);
        var cells = row.findElements(By.tagName("td"));
        List<String> cellData = new ArrayList<>();

        if(cells.size() == 7) {
            cellData.add(getImageItemSrc(cells.get(0)));
            cellData.add(cells.get(1).getText());
            cellData.add(cells.get(2).getText());
            cellData.add(cells.get(3).getText());
            cellData.add(getQuantityInputValue(cells.get(4)));
            cellData.add(cells.get(5).getText());
            cellData.add(getDeleteButtonHref(cells.get(6)));
        }
        else {
            throw new IllegalArgumentException("Row does not contain 7 cells");
        }

        return cellData;
    }

    public int getQuantity(int rowNumber) {
        var row = getRow(rowNumber);
        var quantityCell = row.findElements(By.tagName("td")).get(ShoppingCartHeader.Quantity.ordinal());

        return Integer.parseInt(getQuantityInputValue(quantityCell));
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
