package temporary.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.checkoutConfirmationPage.CheckoutConfirmationPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.CartPageSteps.goToCheckout;
import static steps.CheckoutConfirmationPageSteps.confirmOrder;
import static steps.MainPageSteps.*;
import static temporary.tests.TestGuestCheckout.loginPage;

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
        loginPage.selectGuestAccountOption();
        loginPage.clickContinueButton();
        //Ilona's part with entering the data into fields
        //Ilona's part with clicking a continue button


        // When:
        confirmOrder();

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=checkout/success");
    }

}

