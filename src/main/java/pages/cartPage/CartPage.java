package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class CartPage {

    protected BasePage basePage;
    public By updateButtonLocator = By.id("cart_update");
    public By checkoutButtonLocator = By.id("cart_checkout1");
    public By continueShoppingButtonLocator = By.xpath(".totals > a:nth-of-type(1)");
    public By finalCheckoutButtonLocator = By.id("cart_checkout2");

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
