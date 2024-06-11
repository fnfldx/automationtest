package temporary.tests;

import enums.MainPageSectionId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.goToCart;
import static steps.BaseSteps.openPage;
import static steps.CartPageSteps.goToCheckout;
import static steps.CheckoutConfirmationPageSteps.confirmOrder;
import static steps.CheckoutConfirmationPageSteps.validateCheckoutSuccess;
import static steps.GuestCheckoutPageSteps.fillGuestCheckoutForm;
import static steps.GuestCheckoutPageSteps.submitGuestCheckoutForm;
import static steps.LoginPageSteps.proceedAsGuest;
import static steps.MainPageSteps.addProductToCart;

public class TestBuyProductAsGuest extends BaseTest {
    @AfterEach
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    @Tag("EndToEnd")
    public void buyProductAsGuest() {
        // Given:
        openPage();
        addProductToCart(MainPageSectionId.FEATURES, 0);
        goToCart();
        goToCheckout();
        proceedAsGuest();
        fillGuestCheckoutForm();
        submitGuestCheckoutForm();

        // When:
        confirmOrder();

        // Then:
        validateCheckoutSuccess();
    }
}