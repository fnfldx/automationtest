package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class ApplyCouponCodeTable {

    public final By applyCouponCodeTable = By.id("coupon");
    public By couponLocator = By.id("coupon_coupon");
    public By applyCouponButtonLocator = By.id("apply_coupon_btn");
    protected BasePage basePage;

    void enterCouponCode(String couponCode) {
        basePage.enterTextToElement(couponLocator, couponCode);
    }

    void clickOnApplyCouponButton() {
        basePage.clickOnElement(applyCouponButtonLocator);
    }
}
