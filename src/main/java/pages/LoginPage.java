package pages;

import org.openqa.selenium.By;

public class LoginPage {
    protected BasePage basePage;

    // Locators:
    public By registerAccountButtonLocator = By.id("accountFrm_accountregister");
    public By guestCheckoutButtonLocator = By.id("accountFrm_accountguest");
    public By loginInputLocator = By.id("loginFrm_loginname");
    public By passwordInputLocator = By.id("loginFrm_password");
    public By loginButtonLocator = By.xpath("//*[@id='loginFrm']/button");
    public By continueButtonLocator = By.xpath("//*[@id='accountFrm']/fieldset/button");

    public LoginPage() {
        this.basePage = new BasePage();
    }

    public void selectRegisterAccountOption() {
        basePage.selectRadioButton(registerAccountButtonLocator);
    }

    public void selectGuestAccountOption() {
        basePage.selectRadioButton(guestCheckoutButtonLocator);
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

    public void clickContinueButton() {
        basePage.clickOnElement(continueButtonLocator);
    }

    public boolean isGuestCheckoutButtonVisible() {
        return basePage.isElementDisplayed(guestCheckoutButtonLocator);
    }
}