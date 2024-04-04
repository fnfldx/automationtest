package pages.cartPage;

import lombok.Getter;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.cartPage.shoppingCartTable.ShoppingCartTable;

@Getter
public class CartPage {

    protected BasePage basePage;
    public By updateButtonLocator = By.id("cart_update");
    public By checkoutButtonLocator = By.id("cart_checkout1");
    public By continueShoppingButtonLocator = By.xpath(".totals > a:nth-of-type(1)");
    public By finalCheckoutButtonLocator = By.id("cart_checkout2");

    public CartPage() {
        this.basePage = new BasePage();
    }

    public ApplyCouponCodeTable applyCouponCodeTable = new ApplyCouponCodeTable();
    public EstimateShippingAndTaxesTable estimateShippingAndTaxesTable = new EstimateShippingAndTaxesTable();
    public TotalsTable totalsTable = new TotalsTable();
    public ShoppingCartTable shoppingCartTable = new ShoppingCartTable();

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
