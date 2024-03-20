package steps;


import pages.cartPage.CartPage;

public class CartPageSteps {

    protected static CartPage cartPage;

    public static void updateCart() {
        cartPage = new CartPage();
        cartPage.clickOnUpdateButton();
    }

    public static void goToCheckout() {
        cartPage = new CartPage();
        cartPage.clickOnFinalCheckoutButton();
    }
}
