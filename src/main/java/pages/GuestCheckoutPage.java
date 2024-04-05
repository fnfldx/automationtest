package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

public class GuestCheckoutPage {
    protected BasePage basePage;

    // Locators:
    public By firstnameInputLocator = By.id("AccountFrm_firstname");
    public By lastnameInputLocator = By.id("AccountFrm_lastname");
    public By emailInputLocator = By.id("AccountFrm_email");
    public By telephoneInputLocator = By.id("AccountFrm_telephone");
    public By faxInputLocator = By.id("AccountFrm_fax");
    public By companyInputLocator = By.id("AccountFrm_company");
    public By address1InputLocator = By.id("AccountFrm_address_1");
    public By address2InputLocator = By.id("AccountFrm_address_2");
    public By cityInputLocator = By.id("AccountFrm_city");
    public By zoneIdInputLocator = By.xpath("//ul[contains(@class, 'currency')]/parent::*");
    public By postcodeInputLocator = By.id("AccountFrm_postcode");
    public By countryIdInputLocator = By.xpath("//ul[contains(@class, 'AccountFrm_country_id')]/parent::*");
    public By loginNameInputLocator = By.id("AccountFrm_loginname");
    public By passwordInputLocator = By.id("AccountFrm_password");
    public By passConfirmInputLocator = By.id("AccountFrm_confirm");
    public By newsletterInputLocator = By.xpath("//*[@id='AccountFrm_newsletter1']/button");


    public GuestCheckoutPage() {
        this.basePage = new BasePage();
    }

    public void enterFirstName(String firstname) { basePage.enterTextToElement(firstnameInputLocator, firstname); }
    public void enterLastName(String lastname) {
        basePage.enterTextToElement(lastnameInputLocator, lastname);
    }
    public void enterEmail(String email) {
        basePage.enterTextToElement(emailInputLocator, email);
    }
    public void enterTelephone(String telephone) { basePage.enterTextToElement(telephoneInputLocator, telephone); }
    public void enterFax(String fax) {
        basePage.enterTextToElement(faxInputLocator, fax);
    }
    public void enterCompany(String company) {
        basePage.enterTextToElement(companyInputLocator, company);
    }
    public void enterAddress_1(String address_1) {
        basePage.enterTextToElement(address1InputLocator, address_1);
    }
    public void enterAddress_2(String address_2) { basePage.enterTextToElement(address2InputLocator, address_2); }
    public void enterCity(String city) {
        basePage.enterTextToElement(cityInputLocator, city);
    }

    protected WebElement locateElement(By zoneIdInputLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zoneIdInputLocator));
        return getWebDriverInstance().findElement(zoneIdInputLocator);
    }

    public void enterPostcode(String postcode) { basePage.enterTextToElement(postcodeInputLocator, postcode); }

    protected WebElement locateElement(By countryIdInputLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryIdInputLocator));
        return getWebDriverInstance().findElement(countryIdInputLocator);
    }
    public void enterLoginName(String loginname) {
        basePage.enterTextToElement(loginNameInputLocator, loginname);
    }

    public void enterPassword(String password) {
        basePage.enterTextToElement(passwordInputLocator, password);
    }
    public void passConfirm(String confirm) {
        basePage.enterTextToElement(passConfirmInputLocator, confirm);
    }
    public boolean newsletter() {
        return basePage.isElementDisplayed(newsletterInputLocator);
    }

}


