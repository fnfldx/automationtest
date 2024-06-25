package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

import static enums.Currency.getPriceAsBigDecimal;

public class TotalsTable {
    public final String totalsTable = "//table[@id='totals_table']";
    public By subTotalLocator = By.xpath(totalsTable + "/tbody/tr[1]/td[2]");
    public By flatShippingRateLocator = By.xpath(totalsTable + "/tbody/tr[2]/td[2]");
    public By totalLocator = By.xpath(totalsTable + "/tbody/tr[3]/td[2]");
    protected BasePage basePage;

    public TotalsTable() {
        this.basePage = new BasePage();
    }

    public BigDecimal getSubTotalPrize() {
        return getPriceAsBigDecimal(basePage.getTextFromElement(subTotalLocator));
    }

    public BigDecimal getFlatShippingRatePrize() {
        return getPriceAsBigDecimal(basePage.getTextFromElement(flatShippingRateLocator));
    }

    public BigDecimal getTotalPrize() {
        return getPriceAsBigDecimal(basePage.getTextFromElement(totalLocator));
    }
}