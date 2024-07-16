package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class ConfirmPaymentOptionsTable {
    public final String confirmPaymentOptionsTableXpath = "//table[contains(@class,'confirm_payment_options')]";
    public By editPaymentButtonLocator = By.xpath(confirmPaymentOptionsTableXpath + "//a[1]");
    public By editCouponButtonLocator = By.xpath(confirmPaymentOptionsTableXpath + "//a[2]");
    protected BasePage basePage;

    public ConfirmPaymentOptionsTable() {
        this.basePage = new BasePage();
    }

    public void clickOnEditPaymentButton() {
        basePage.clickOnElement(editPaymentButtonLocator);
    }

    public void clickOnEditCouponButton() {
        basePage.clickOnElement(editCouponButtonLocator);
    }
}