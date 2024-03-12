package pages.cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CartPage {

    protected WebDriver driver;
    public By updateButtonLocator = By.id("cart_update");
    public By checkoutButtonLocator = By.id("cart_checkout1");
    public By continueShoppingButtonLocator = By.xpath("//a[@class='btn btn-default mr10  mb10']");
    public By finalCheckoutButtonLocator = By.id("cart_checkout2");

    BasePage basePage = new BasePage(driver);
    ApplyCouponCodeTable applyCouponCodeTable = new ApplyCouponCodeTable();
    EstimateShippingAndTaxesTable estimateShippingAndTaxesTable = new EstimateShippingAndTaxesTable();
    TotalsTable totalsTable = new TotalsTable();

    public void clickOnUpdateButton() {
        basePage.clickOnElement(updateButtonLocator);
    }

    public void clickOnCheckoutButton() {
        basePage.clickOnElement(checkoutButtonLocator);
    }

    public void clickOnContinueShoppingButton() {
        basePage.clickOnElement(continueShoppingButtonLocator);
    }

    public void clickOnFinalCheckoutButton() {
        basePage.clickOnElement(finalCheckoutButtonLocator);
    }


}
