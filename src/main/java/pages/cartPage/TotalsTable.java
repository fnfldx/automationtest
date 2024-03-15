package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class TotalsTable {

    protected BasePage basePage;
    public final String totalsTable = "//table[@id='totals_table']";
    public By subTotalLocator = By.xpath(totalsTable + "//tbody/tr[1]/td[2]/span");
    public By flatShippingRateLocator = By.xpath(totalsTable + "//tbody/tr[2]/td[2]/span");
    public By totalLocator = By.xpath(totalsTable + "//tbody/tr[3]/td[2]/span");

    void getSubTotalValue() {
        basePage.getTextFromElement(subTotalLocator);
    }

    void getFlatShippingRateValue() {
        basePage.getTextFromElement(flatShippingRateLocator);
    }

    void getTotalValue() {
        basePage.getTextFromElement(totalLocator);
    }
}
