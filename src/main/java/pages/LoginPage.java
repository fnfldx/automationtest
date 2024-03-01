package pages;

import enums.BrowserName;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Constructor:
    public LoginPage(BrowserName browserName) {
        super(browserName);
    }

    // Locators:
    private By loginInputLocator = By.xpath("//*[@id=\"loginFrm_loginname\"]");
    private By passwordInputLocator = By.xpath("//*[@id=\"loginFrm_password\"]");
    private By loginButtonLocator = By.xpath("//*[@id=\"loginFrm\"]/fieldset/button");
    private By registerAccountButtonLocator = By.xpath("//*[@id=\"accountFrm_accountregister\"]");
    private By guestCheckoutButtonLocator = By.xpath("//*[@id=\"accountFrm_accountguest\"]");

    // Methods:
    public void enterEmail(String email) {
        enterTextToElement(loginInputLocator, email);
    }

    public void enterPassword(String password) {
        enterTextToElement(passwordInputLocator, password);
    }

    public void clickLoginButton() {
        clickOnElement(loginButtonLocator);
    }

    public void registerAccountOption() {
        clickOnElement(registerAccountButtonLocator);
    }

    public void guestAccountOption() {
        clickOnElement(guestCheckoutButtonLocator);
    }
}