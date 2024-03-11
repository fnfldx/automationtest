package pages;

import enums.BrowserName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage {

    private BasePage basePage;

    // Locators:
    public By registerAccountButtonLocator = By.id("accountFrm_accountregister");   
    public By guestCheckoutButtonLocator = By.id("accountFrm_accountguest");
    public By loginInputLocator = By.id("loginFrm_loginname");
    public By passwordInputLocator = By.id("loginFrm_password");
    public By loginButtonLocator = By.xpath("//*[@id='loginFrm']/button");

    public LoginPage(BrowserName browserName) {
    }

    public void selectRegisterAccountOption() {
        basePage.isElementDisplayed(registerAccountButtonLocator);
    }

    public void selectGuestAccountOption() {
        if (basePage.isElementDisplayed(guestCheckoutButtonLocator)) {
            basePage.clickOnElement(guestCheckoutButtonLocator);
        } else {
            throw new NoSuchElementException("Guest Checkout button is not present when there are no items in the cart. You need to add at least one item to cart.");
        }
    }

    public void enterEmail(String email) {
        basePage.enterTextToElement(loginInputLocator, email);
    }

    public void enterPassword(String password) {
        basePage.enterTextToElement(passwordInputLocator, password);
    }

    public void clickLoginButton() {
        basePage.clickOnElement(loginButtonLocator);
    }
}