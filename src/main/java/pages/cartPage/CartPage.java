package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class CartPage {
    public By updateButtonLocator = By.id("cart_update");
    public By checkoutButtonLocator = By.id("cart_checkout1");
    public By finalCheckoutButtonLocator = By.id("cart_checkout2");
    public By continueShoppingButtonLocator = By.xpath("//i[contains(@class,'fa-arrow-right')]/parent::a");
    protected ApplyCouponCodeTable applyCouponCodeTable = new ApplyCouponCodeTable();
    protected EstimateShippingAndTaxesTable estimateShippingAndTaxesTable = new EstimateShippingAndTaxesTable();
    protected TotalsTable totalsTable = new TotalsTable();
    protected BasePage basePage;

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
