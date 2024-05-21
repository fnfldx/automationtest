package temporary.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static steps.BaseSteps.addToCart;
import static steps.BaseSteps.goToCart;
import static steps.BaseSteps.openPage;
import static steps.BaseSteps.validateURL;
import static steps.CartPageSteps.goToCheckout;
import static steps.CartPageSteps.updateCart;
import static steps.LoginPageSteps.goToAccountLogin;
import static steps.LoginPageSteps.proceedAsGuest;

public class TestGuestCheckout extends BaseTest {

    protected static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        loginPage = new LoginPage();
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
}