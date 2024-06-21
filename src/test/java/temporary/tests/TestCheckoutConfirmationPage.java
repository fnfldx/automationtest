package temporary.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.checkoutConfirmationPage.CheckoutConfirmationPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.*;
import static steps.CartPageSteps.goToCheckout;
import static steps.CheckoutConfirmationPageSteps.confirmOrder;
import static steps.GuestCheckoutPageSteps.fillGuestCheckoutForm;
import static steps.GuestCheckoutPageSteps.submitGuestCheckoutForm;
import static steps.LoginPageSteps.proceedAsGuest;

public class TestCheckoutConfirmationPage extends BaseTest {

    protected static CheckoutConfirmationPage checkoutConfirmationPage;

    @BeforeAll
    public static void setUp() {
        checkoutConfirmationPage = new CheckoutConfirmationPage();
    }

    @AfterEach
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    @Tag("EndToEnd")
    public void proceedToCheckout() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        goToCheckout();
        proceedAsGuest();
        fillGuestCheckoutForm();
        submitGuestCheckoutForm();

        // When:
        confirmOrder();

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=checkout/success");
    }
}