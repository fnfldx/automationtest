package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class ApplyCouponCodeTable {

    public By applyCouponCodeTableLocator = By.xpath("//div[contains(@class,'coupon')]/table");
    public By applyCouponCodeFormLocator = By.id("coupon");
    public By couponInputLocator = By.id("coupon_coupon");
    public By applyCouponButtonLocator = By.id("apply_coupon_btn");
    protected BasePage basePage;

    void enterCouponCode(String couponCode) {
        basePage.enterTextToElement(couponInputLocator, couponCode);
    }

    void clickOnApplyCouponButton() {
        basePage.clickOnElement(applyCouponButtonLocator);
    }
}