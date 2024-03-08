package cartPage;

import org.openqa.selenium.By;

public class ApplyCouponCodeTable {

    public final String applyCouponCodeTable = "//*[@id='cart']/div/div[2]/div[1]";
    public By couponLocator = By.xpath(applyCouponCodeTable + "//input[@id='coupon_coupon']");
    public By applyCouponButtonLocator = By.xpath(applyCouponCodeTable + "//button[@id='apply_coupon_btn']");
}
