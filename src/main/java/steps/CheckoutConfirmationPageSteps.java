package steps;


import pages.checkoutConfirmationPage.CheckoutConfirmationPage;

public class CheckoutConfirmationPageSteps {

    protected static CheckoutConfirmationPage checkoutConfirmationPage;

    public static void backToCheckoutStep2() {
        checkoutConfirmationPage = new CheckoutConfirmationPage();
        checkoutConfirmationPage.clickOnBackButton();
    }

    public static void confirmOrder() {
        checkoutConfirmationPage = new CheckoutConfirmationPage();
        checkoutConfirmationPage.clickOnConfirmOrderButton();
    }
}
