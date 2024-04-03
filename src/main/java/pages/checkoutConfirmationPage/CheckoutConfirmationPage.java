package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class CheckoutConfirmationPage {

    protected BasePage basePage;

    public By ReturnPolicyLocator = By.xpath("//b[normalize-space()='Return Policy']");
    public By CloseReturnPolicyCrossLocator = By.xpath("//*[@id='returnPolicyModal']/div/div/div[1]/button");
    public By CloseReturnPolicyButtonLocator = By.xpath("//*[@id='returnPolicyModal']/div/div/div[3]/button");
    public final String totalsTable = "//*[@id='maincontainer']/div/div[1]/div/div[2]/div/div[1]/table";
    public By subTotalLocator = By.xpath(totalsTable + "/tbody/tr[1]/td[2]/span");
    public By flatShippingRateLocator = By.xpath(totalsTable + "/tbody/tr[2]/td[2]/span");
    public By totalLocator = By.xpath(totalsTable + "/tbody/tr[3]/td[2]/span");
    public By BackButtonLocator = By.id("back");
    public By ConfirmOrderButtonLocator = By.id("checkout_btn");

    public CheckoutConfirmationPage() {
        this.basePage = new BasePage();
    }

    public void clickOnReturnPolicy() {
        basePage.clickOnElement(ReturnPolicyLocator);
    }

    public void clickOnCloseReturnPolicyByCross() {
        basePage.clickOnElement(CloseReturnPolicyCrossLocator);
    }

    public void clickOnCloseReturnPolicy() {
        basePage.clickOnElement(CloseReturnPolicyButtonLocator);
    }

    public void getSubTotalValue() {
        basePage.getTextFromElement(subTotalLocator);
    }

    public void getFlatShippingRateValue() {
        basePage.getTextFromElement(flatShippingRateLocator);
    }

    public void getTotalValue() {
        basePage.getTextFromElement(totalLocator);
    }

    public void clickOnBackButton() {
        basePage.clickOnElement(BackButtonLocator);
    }

    public void clickOnConfirmOrderButton() {
        basePage.clickOnElement(ConfirmOrderButtonLocator);
    }


}
