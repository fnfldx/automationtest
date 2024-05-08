package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

public class OrderSummaryTable {

    public final String totalsTable = "//*[@id='maincontainer']/div/div[2]/div[1]/table[2]";
    public By subTotalLocator = By.xpath(totalsTable + "/tbody/tr[1]/td[2]/span");
    public By flatShippingRateLocator = By.xpath(totalsTable + "/tbody/tr[2]/td[2]/span");
    public By totalLocator = By.xpath(totalsTable + "/tbody/tr[3]/td[2]/span");
    protected BasePage basePage;

    public BigDecimal getSubTotalValue() {
        return new BigDecimal(basePage.getTextFromElement(subTotalLocator).trim());
    }

    public BigDecimal getFlatShippingRateValue() {
        return new BigDecimal(basePage.getTextFromElement(flatShippingRateLocator).trim());
    }

    public BigDecimal getTotalValue() {
        return new BigDecimal(basePage.getTextFromElement(totalLocator).trim());
    }
}
