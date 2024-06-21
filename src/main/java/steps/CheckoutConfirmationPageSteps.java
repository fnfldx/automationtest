package steps;


import org.junit.Assert;
import org.openqa.selenium.By;
import pages.checkoutConfirmationPage.CheckoutConfirmationPage;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static enums.TranslationKey.SUCCESS_CHECKOUT_MESSAGE;
import static steps.BaseSteps.validateURL;

public class CheckoutConfirmationPageSteps {

    protected static CheckoutConfirmationPage checkoutConfirmationPage;

    public static void backToCheckoutStep2() {
        checkoutConfirmationPage = new CheckoutConfirmationPage();
        checkoutConfirmationPage.clickOnBackButton();
    }

    public static void confirmOrder() {
        checkoutConfirmationPage = new CheckoutConfirmationPage();
        checkoutConfirmationPage.clickOnConfirmOrderButton();
        checkoutConfirmationPage.waitForLoadingSpinnerToDisappear();
    }

    public static void validateCheckoutSuccess() {
        validateURL("https://automationteststore.com/index.php?rt=checkout/success");
        var successMessage = getWebDriverInstance().findElement(By.xpath("//span[@class='maintext']")).getText();
        Assert.assertTrue("The success message is not correct", successMessage.contains(SUCCESS_CHECKOUT_MESSAGE.getTranslation()));
    }
}