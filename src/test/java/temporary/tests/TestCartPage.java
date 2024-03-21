package temporary.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.cartPage.CartPage;
import steps.MainPageSteps;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.CartPageSteps.goToCheckout;
import static steps.MainPageSteps.*;

public class TestCartPage extends BaseTest {

    protected static CartPage cartPage;
    protected static MainPageSteps mainPageSteps;

    @BeforeClass
    public static void setUp() {
        cartPage = new CartPage();
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

        // When:
        goToCheckout();

        // Then:
        MainPageSteps.validateURL("https://automationteststore.com/index.php?rt=account/login");
    }

}

