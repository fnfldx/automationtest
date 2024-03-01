package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    private By emailInput = By.id("loginFrm_loginname");
    private By passwordInput = By.id("loginFrm_password");
    private By loginButton = By.cssSelector("button[title='Login']");
    private By registerAccountButton = By.id("accountFrm_accountregister");
    private By guestCheckoutButton = By.id("accountFrm_accountguest");

    public void enterEmail (String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.sendKeys(email);
    }

    public void enterPassword (String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    public void registerAccountOption() {
        WebElement registerAccountBtn = driver.findElement(registerAccountButton);
        registerAccountBtn.click();
    }

    public void guestAccountOption() {
        WebElement guestCheckoutBtn = driver.findElement(guestCheckoutButton);
        guestCheckoutBtn.click();
    }
}
