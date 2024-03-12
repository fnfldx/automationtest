package pages.cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ApplyCouponCodeTable {

    protected WebDriver driver;
    public String couponCode = "";
    public final By applyCouponCodeTable = By.id("coupon");
    public By couponLocator = By.id("coupon_coupon");
    public By applyCouponButtonLocator = By.id("apply_coupon_btn");

    BasePage basePage = new BasePage(driver);

    void enterCouponCode() {
        basePage.enterTextToElement(couponLocator, couponCode);
    }

    void clickOnApplyCouponButton() {
        basePage.clickOnElement(applyCouponButtonLocator);
    }
}
