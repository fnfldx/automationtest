package temporary.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.OrderConfirmationPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.*;
import static steps.CartPageSteps.goToCheckout;
import static steps.CartPageSteps.updateCart;
import static steps.CheckoutConfirmationPageSteps.confirmOrder;
import static steps.GuestCheckoutPageSteps.fillGuestCheckoutForm;
import static steps.GuestCheckoutPageSteps.submitGuestCheckoutForm;
import static steps.LoginPageSteps.proceedAsGuest;
import static steps.OrderConfirmationSteps.*;

public class TestOrderConfirmation extends BaseTest {
    protected static OrderConfirmationPage orderConfirmationPage;

    @BeforeAll
    public static void setUp() {
        orderConfirmationPage = new OrderConfirmationPage();
    }

    @AfterEach
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    @Tag("EndToEnd")
    public void proceedToInvoicePage() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();
        fillGuestCheckoutForm();
        submitGuestCheckoutForm();
        confirmOrder();

        // When:
        goToInvoicePage();

        // Then:
        validateURLContains("https://automationteststore.com/index.php?rt=account/invoice");
    }

    @Test
    @Tag("EndToEnd")
    public void proceedToContactPage() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();
        fillGuestCheckoutForm();
        submitGuestCheckoutForm();
        confirmOrder();

        // When:
        goToContactPage();

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=content/contact");
    }

    @Test
    @Tag("EndToEnd")
    public void continueShopping() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();
        fillGuestCheckoutForm();
        submitGuestCheckoutForm();
        confirmOrder();

        // When:
        goToContinueShopping();

        // Then:
        validateURL("https://automationteststore.com/");
    }
}