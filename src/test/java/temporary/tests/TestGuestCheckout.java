package temporary.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.GuestCheckoutPage;
import pages.LoginPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static steps.BaseSteps.addToCart;
import static steps.BaseSteps.goToCart;
import static steps.BaseSteps.openPage;
import static steps.BaseSteps.validateURL;
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

    @BeforeAll
    public static void setUp() {
        loginPage = new LoginPage();
        guestCheckoutPage = new GuestCheckoutPage();
    }

    @AfterEach
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    @Tag("EndToEnd")
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
    @Tag("EndToEnd")
    public void proceedToLoginOrRegister() {
        // Given:
        openPage();

        // When:
        goToAccountLogin();

        // Then:
        assertThat(loginPage.isGuestCheckoutButtonVisible()).isFalse();
    }

    @Test
    @Tag("EndToEnd")
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
    @Tag("EndToEnd")
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