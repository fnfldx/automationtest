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
    public void isOrderProcessed() {
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
        // TODO: Kuba to create 'order confirmation step'

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=checkout/success");
    }
}