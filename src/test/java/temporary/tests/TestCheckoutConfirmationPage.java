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
import static temporary.tests.TestGuestCheckout.loginPage;

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
        loginPage.selectGuestAccountOption();
        loginPage.clickContinueButton();
        // TODO: Ilona's part with entering the data into fields
        // TODO: Ilona's part with clicking a continue button


        // When:
        confirmOrder();

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=checkout/success");
    }

}

