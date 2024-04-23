package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class TableConfirmPaymentOptions {

    protected BasePage basePage;

    public By editPaymentButtonLocator = By.xpath("//a[normalize-space()='Edit Payment']");
    public By editCouponButtonLocator = By.xpath("//a[normalize-space()='Edit Coupon']");

    public TableConfirmPaymentOptions() {
        this.basePage = new BasePage();
    }

    public void clickOnEditPaymentButton() {
        basePage.clickOnElement(editPaymentButtonLocator);
    }

    public void clickOnEditCouponButton() {
        basePage.clickOnElement(editCouponButtonLocator);
    }
}
