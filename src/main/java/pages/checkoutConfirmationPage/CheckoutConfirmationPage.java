package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

public class CheckoutConfirmationPage {

    protected BasePage basePage;

    public By returnPolicyLocator = By.xpath("//b[normalize-space()='Return Policy']");
    public By closeReturnPolicyCrossLocator = By.xpath("//*[@id='returnPolicyModal']/div/div/div[1]/button");
    public By closeReturnPolicyButtonLocator = By.xpath("//*[@id='returnPolicyModal']/div/div/div[3]/button");
    public final String totalsTable = "//div[contains(@class, 'confirm_total')]//table";
    public By subTotalLocator = By.xpath(totalsTable + "/tbody/tr[1]/td[2]/span");
    public By flatShippingRateLocator = By.xpath(totalsTable + "/tbody/tr[2]/td[2]/span");
    public By totalLocator = By.xpath(totalsTable + "/tbody/tr[3]/td[2]/span");
    public By backButtonLocator = By.id("back");
    public By confirmOrderButtonLocator = By.id("checkout_btn");

    public CheckoutConfirmationPage() {
        this.basePage = new BasePage();
    }

    public void clickOnReturnPolicy() {
        basePage.clickOnElement(returnPolicyLocator);
    }

    public void clickOnCloseReturnPolicyByCross() {
        basePage.clickOnElement(closeReturnPolicyCrossLocator);
    }

    public void clickOnCloseReturnPolicy() {
        basePage.clickOnElement(closeReturnPolicyButtonLocator);
    }

    public BigDecimal getSubTotalValue() {
        return new BigDecimal(basePage.getTextFromElement(subTotalLocator).trim());
    }

    public BigDecimal getFlatShippingRateValue() {
        return new BigDecimal(basePage.getTextFromElement(flatShippingRateLocator).trim());
    }

    public BigDecimal getTotalValue() {
        return new BigDecimal(basePage.getTextFromElement(totalLocator).trim());
    }

    public void clickOnBackButton() {
        basePage.clickOnElement(backButtonLocator);
    }

    public void clickOnConfirmOrderButton() {
        basePage.clickOnElement(confirmOrderButtonLocator);
    }


}
