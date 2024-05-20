package temporary.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.GuestCheckoutPage;
import pages.LoginPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static steps.BaseSteps.*;
import static steps.CartPageSteps.goToCheckout;
import static steps.CartPageSteps.updateCart;
import static steps.GuestCheckoutPageSteps.fillGuestCheckoutWithShippingAddressForm;
import static steps.LoginPageSteps.goToAccountLogin;
import static steps.LoginPageSteps.proceedAsGuest;
import static steps.GuestCheckoutPageSteps.fillGuestCheckoutForm;
import static steps.GuestCheckoutPageSteps.submitGuestCheckoutForm;

public class TestGuestCheckout extends BaseTest {

    protected static LoginPage loginPage;
    protected static GuestCheckoutPage guestCheckoutPage;

    @BeforeClass
    public static void setUp() {
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    public void continueAsGuest() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();

        // When:
        proceedAsGuest();

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=checkout/guest_step_1");

    }

    @Test
    public void proceedToLoginOrRegister() {
        // Given:
        openPage();

        // When:
        goToAccountLogin();

        // Then:
        assertThat(loginPage.isGuestCheckoutButtonVisible()).isFalse();
    }

    @Test
    public void fillGuestCheckoutFormTest() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();

        // When:
        fillGuestCheckoutForm();
        submitGuestCheckoutForm();

        //Then
        validateURL("https://automationteststore.com/index.php?rt=checkout/guest_step_3");
    }

    @Test
    public void fillGuestCheckoutWithShippingAddressFormTest() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();
        proceedAsGuest();

        // When:
        fillGuestCheckoutWithShippingAddressForm();
        submitGuestCheckoutForm();

        //Then
        validateURL("https://automationteststore.com/index.php?rt=checkout/guest_step_3");
    }
}