package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static enums.Currency.getPriceAsBigDecimal;

public class ConfirmProductsTable {
    public final String confirmProductsTableXpath = "//table[contains(@class,'confirm_products')]";
    public final String confirmProductRowXpath = confirmProductsTableXpath + "/tbody/tr";
    protected BasePage basePage;

    public ConfirmProductsTable() {
        this.basePage = new BasePage();
    }

    public int getNumberOfProducts() {
        return getWebDriverInstance().findElements(By.xpath(confirmProductRowXpath)).size();
    }

    public String getProductImageSrcFromRow(int productIndex) {
        var productXpath = String.format("%s[%d]/td[1]/img", confirmProductRowXpath, productIndex);
        return getWebDriverInstance().findElement(By.xpath(productXpath)).getAttribute("src");
    }

    public String getProductNameFromRow(int productIndex) {
        var productXpath = String.format("%s[%d]/td[2]/a", confirmProductRowXpath, productIndex);
        return getWebDriverInstance().findElement(By.xpath(productXpath)).getText();
    }

    public BigDecimal getProductPriceFromRow(int productIndex) {
        var productXpath = String.format("%s[%d]/td[3]", confirmProductRowXpath, productIndex);
        var priceText = getWebDriverInstance().findElement(By.xpath(productXpath)).getText();
        return getPriceAsBigDecimal(priceText);
    }

    public int getProductQuantityFromRow(int productIndex) {
        var productXpath = String.format("%s[%d]/td[4]", confirmProductRowXpath, productIndex);
        return Integer.parseInt(getWebDriverInstance().findElement(By.xpath(productXpath)).getText());
    }

    public BigDecimal getProductTotalPriceFromRow(int productIndex) {
        var productXpath = String.format("%s[%d]/td[5]", confirmProductRowXpath, productIndex);
        var totalPriceText = getWebDriverInstance().findElement(By.xpath(productXpath)).getText();
        return getPriceAsBigDecimal(totalPriceText);
    }
}