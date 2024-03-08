package cartPage;

import org.openqa.selenium.By;

public class ApplyCouponCodeTable {

    public final String ApplyCouponCodeTable = "//*[@id='cart']/div/div[2]/div[1]";
    public By CouponLocator = By.xpath(ApplyCouponCodeTable + "//input[@id='coupon_coupon']");
    public By applyCouponButtonLocator = By.xpath(ApplyCouponCodeTable + "//button[@id='apply_coupon_btn']");
}
