package steps;

import pages.OrderConfirmationPage;

public class OrderConfirmationSteps {
    protected static OrderConfirmationPage orderConfirmationPage;

    public static void goToInvoicePage() {
        orderConfirmationPage = new OrderConfirmationPage();
        orderConfirmationPage.navigateToInvoicePage();
    }

    public static void goToContactPage() {
        orderConfirmationPage = new OrderConfirmationPage();
        orderConfirmationPage.navigateToContactPage();
    }

    public static void goToContinueShopping() {
        orderConfirmationPage = new OrderConfirmationPage();
        orderConfirmationPage.navigateToContinueShopping();
    }
}