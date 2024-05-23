package temporary.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
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

    @BeforeClass
    public static void setUp() {
        checkoutConfirmationPage = new CheckoutConfirmationPage();
    }

    @After
    public void tearDown() {
        quitWebDriver();
    }

    @Test
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