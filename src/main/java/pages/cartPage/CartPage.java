package pages.cartPage;

import lombok.Getter;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.cartPage.shoppingCartTable.ShoppingCartTable;

public class CartPage {
    public By updateButtonLocator = By.id("cart_update");
    public By checkoutButtonLocator = By.id("cart_checkout1");
    public By finalCheckoutButtonLocator = By.id("cart_checkout2");
    public By continueShoppingButtonLocator = By.xpath("//i[contains(@class,'fa-arrow-right')]/parent::a");
    public ShoppingCartTable shoppingCartTable;
    public ApplyCouponCodeTable applyCouponCodeTable;
    public EstimateShippingAndTaxesTable estimateShippingAndTaxesTable;
    public TotalsTable totalsTable;
    public BasePage basePage;

    public CartPage() {
        this.basePage = new BasePage();
        this.shoppingCartTable = new ShoppingCartTable();
        this.applyCouponCodeTable = new ApplyCouponCodeTable();
        this.estimateShippingAndTaxesTable = new EstimateShippingAndTaxesTable();
        this.totalsTable = new TotalsTable();
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
