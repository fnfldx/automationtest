package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static enums.Currency.convertCurrencyFromCookie;

public class OrderSummaryTable {
    public final String orderSummaryXpath = "//div[@class='sidewidt']";
    public final String productXpath = "//div[@class='sidewidt']/table[1]//tr";
    public By productListTableLocator = By.xpath(orderSummaryXpath + "/table[1]");
    public By totalsTableLocator = By.xpath(orderSummaryXpath + "/table[2]");
    public By subTotalLocator = By.xpath(orderSummaryXpath + "/table[2]/tbody/tr[1]/td[2]");
    public By flatShippingRateLocator = By.xpath(orderSummaryXpath + "/table[2]/tbody/tr[2]/td[2]");
    public By totalLocator = By.xpath(orderSummaryXpath + "/table[2]/tbody/tr[3]/td[2]");
    protected BasePage basePage;

    public int getProductsListSize() {
        return getWebDriverInstance().findElements(By.xpath(orderSummaryXpath)).size();
    }

    public String getProductNameFromProductsList(int index) {
        var formattedProductXpath = String.format("%s[%d]/td[1]/a", productXpath, index);
        return getWebDriverInstance().findElement(By.xpath(formattedProductXpath)).getText();
    }

    public int getProductQuantityFromProductsList(int index) {
        var formattedProductXpath = String.format("%s[%d]/td[1]", productXpath, index);
        var quantityText = getWebDriverInstance().findElement(By.xpath(formattedProductXpath)).getText();
        var splitText = quantityText.split(" ");
        return Integer.parseInt(splitText[0]);
    }

    public BigDecimal getProductPriceFromProductsList(int index) {
        var formattedProductXpath = String.format("%s[%d]/td[2]", productXpath, index);
        return convertCurrencyFromCookie(getWebDriverInstance().findElement(By.xpath(formattedProductXpath)).getText());
    }

    public BigDecimal getSubTotalValue() {
        return convertCurrencyFromCookie(basePage.getTextFromElement(subTotalLocator));
    }

    public BigDecimal getFlatShippingRateValue() {
        return convertCurrencyFromCookie(basePage.getTextFromElement(flatShippingRateLocator));
    }

    public BigDecimal getTotalValue() {
        return convertCurrencyFromCookie(basePage.getTextFromElement(totalLocator));
    }
}