package steps;

import pages.OrderConfirmationPage;

public class OrderConfirmationSteps {
    protected static OrderConfirmationPage orderConfirmationPage;

    public static void proceedToInvoicePage() {
        orderConfirmationPage = new OrderConfirmationPage();
        orderConfirmationPage.goToInvoicePage();
    }

    public static void proceedToContactPage() {
        orderConfirmationPage = new OrderConfirmationPage();
        orderConfirmationPage.goToContactWithStoreOwner();
    }

    public static void continueShopping() {
        orderConfirmationPage = new OrderConfirmationPage();
        orderConfirmationPage.continueShopping();
    }
}