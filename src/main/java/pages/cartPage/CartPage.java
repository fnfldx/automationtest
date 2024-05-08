package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class CartPage {

    public By updateButtonLocator = By.id("cart_update");
    public By checkoutButtonLocator = By.id("cart_checkout1");
    public By continueShoppingButtonLocator = By.xpath(".totals > a:nth-of-type(1)");
    public By finalCheckoutButtonLocator = By.id("cart_checkout2");
    protected BasePage basePage;
    ApplyCouponCodeTable applyCouponCodeTable = new ApplyCouponCodeTable();
    EstimateShippingAndTaxesTable estimateShippingAndTaxesTable = new EstimateShippingAndTaxesTable();
    TotalsTable totalsTable = new TotalsTable();
    public CartPage() {
        this.basePage = new BasePage();
    }

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
