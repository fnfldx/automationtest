package temporary.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.OrderConfirmationPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.*;
import static steps.CartPageSteps.goToCheckout;
import static steps.CartPageSteps.updateCart;
import static steps.CheckoutConfirmationPageSteps.confirmOrder;
import static steps.LoginPageSteps.proceedAsGuest;
import static steps.OrderConfirmationSteps.*;

public class TestOrderConfirmation extends BaseTest {
    protected static OrderConfirmationPage orderConfirmationPage;

    @BeforeClass
    public static void setUp() {
        orderConfirmationPage = new OrderConfirmationPage();
    }

    @After
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    public void proceedToInvoicePage() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();
        // TODO: Ilona's part with entering the data into fields
        // TODO: Ilona's part with clicking a continue button
        confirmOrder();

        // When:
        goToInvoicePage();

        // Then:
        validateURLContains("https://automationteststore.com/index.php?rt=account/invoice");
    }

    @Test
    public void proceedToContactPage() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();
        // TODO: Ilona's part with entering the data into fields
        // TODO: Ilona's part with clicking a continue button
        confirmOrder();

        // When:
        goToContactPage();

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=content/contact");
    }

    @Test
    public void continueShopping() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();
        // TODO: Ilona's part with entering the data into fields
        // TODO: Ilona's part with clicking a continue button
        confirmOrder();

        // When:
        goToContinueShopping();

        // Then:
        validateURL("https://automationteststore.com/");
    }
}