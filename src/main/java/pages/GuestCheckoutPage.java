package pages;

import org.openqa.selenium.By;

public class GuestCheckoutPage {
    protected BasePage basePage;

    public By firstNameInputLocator = By.id("guestFrm_firstname");
    public By lastNameInputLocator = By.id("guestFrm_lastname");
    public By emailInputLocator = By.id("guestFrm_email");
    public By telephoneInputLocator = By.id("guestFrm_telephone");
    public By faxInputLocator = By.id("guestFrm_fax");
    public By companyInputLocator = By.id("guestFrm_company");
    public By address1InputLocator = By.id("guestFrm_address_1");
    public By address2InputLocator = By.id("guestFrm_address_2");
    public By cityInputLocator = By.id("guestFrm_city");
    public By regionInputLocator = By.id("guestFrm_zone_id");
    public By postCodeInputLocator = By.id("guestFrm_postcode");
    public By countryInputLocator = By.id("guestFrm_country_id");
    //Shipping address inputs
    public By firstNameShippingInputLocator = By.id("guestFrm_shipping_firstname");
    public By lastNameShippingInputLocator = By.id("guestFrm_shipping_lastname");
    public By emailShippingInputLocator = By.id("guestFrm_shipping_email");
    public By companyShippingInputLocator = By.id("guestFrm_shipping_company");
    public By address1ShippingInputLocator = By.id("guestFrm_shipping_address_1");
    public By address2ShippingInputLocator = By.id("guestFrm_shipping_address_2");
    public By cityShippingInputLocator = By.id("guestFrm_shipping_city");
    public By regionShippingInputLocator = By.id("guestFrm_shipping_zone_id");
    public By postCodeShippingInputLocator = By.id("guestFrm_shipping_postcode");
    public By countryShippingInputLocator = By.id("guestFrm_shipping_country_id");
    //Buttons
    public By backButton = By.xpath("//a[@title='Back']");
    public By continueButton = By.xpath("//button[@title='Continue']");
    //Checkbox shipping address
    public By shippingAddressCheckbox = By.id("guestFrm_shipping_indicator");

    public GuestCheckoutPage() {
        this.basePage = new BasePage();
    }

    public void clickOnBackButton() {
        basePage.clickOnElement(backButton);
    }

    public void clickOnContinueButton() {
        basePage.clickOnElement(continueButton);
    }

    public void selectShippingAddressCheckbox() {
        basePage.selectCheckbox(shippingAddressCheckbox);
    }

    public void unselectShippingAddressCheckBox() {
        basePage.unselectCheckbox(shippingAddressCheckbox);
    }

    public void fillInput(By input, String value) {
        basePage.enterTextToElement(input, value);
    }

    public void selectOptionRegionOrCountry(By locator, String option) {
        basePage.selectionOptionFromDropdown(locator, option);
    }
}