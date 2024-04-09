package pages.createAccountPage;

import lombok.Getter;
import lombok.Setter;
import models.AccountModel;
import models.CustomerModel;
import org.openqa.selenium.By;
import pages.BasePage;

@Getter
@Setter
public class CreateAccountPage {
    protected BasePage basePage;
    public AccountModel accountModel;
    public CustomerModel customerModel;

    public String alertMessageXpath = "//div[contains(@class, 'alert-error')]";
    public By alertMessageLocator = By.xpath(alertMessageXpath);
    public By alertMessageCloseButtonLocator = By.xpath(alertMessageXpath + "//button[@class='close']");
    public By continueButtonLocator = By.xpath("//button[@title='Continue']");

    public CreateAccountPage() {
        this.basePage = new BasePage();
        this.accountModel = new AccountModel();
        this.customerModel = accountModel.getCustomerModel();
    }

    public CreateAccountPage(CustomerModel customerModel, Boolean isSubscribedToNewsletter) {
        this.basePage = new BasePage();
        this.accountModel = new AccountModel(customerModel, isSubscribedToNewsletter);
        this.customerModel = customerModel;
    }

    public By inputFormLocator(CreateAccountInput input) {
        return By.id(input.getId());
    }

    public By inputHelpTextLocator(CreateAccountInput input) {
        return By.xpath("//input[@id='" + input.getId() + "']/ancestor::div/span[@class='help-block']");
    }

    public Boolean isRequiredSymbolDisplayed(CreateAccountInput input) {
        return basePage.isElementDisplayed(By.xpath("//input[@id='" + input.getId() + "']/parent::div//span[@class='required']"));
    }

    public String getHelpText(CreateAccountInput input) {
        return basePage.getTextFromElement(inputHelpTextLocator(input));
    }

    public void closeAlertMessage() {
        basePage.clickOnElement(alertMessageCloseButtonLocator);
    }

    public void clickContinueButton() {
        basePage.clickOnElement(continueButtonLocator);
    }

    public void fillInput(CreateAccountInput input, String value) {
        basePage.enterTextToElement(inputFormLocator(input), value);
    }

    public void selectStateOrCountry(CreateAccountInput input, String value) {
        var element = inputFormLocator(input);
        basePage.selectionOptionFromDropdown(element, value);
    }

    public void subscribeToNewsletter(boolean subscribe) {
        CreateAccountInput input = subscribe ? CreateAccountInput.SUBSCRIBE_YES : CreateAccountInput.SUBSCRIBE_NO;
        basePage.selectRadioButton(inputFormLocator(input));
    }

    public void acceptPrivacyPolicy() {
        basePage.selectCheckbox(inputFormLocator(CreateAccountInput.PRIVACY_POLICY));
    }

    public void unselectPrivacyPolicy() {
        basePage.unselectCheckbox(inputFormLocator(CreateAccountInput.PRIVACY_POLICY));
    }

    public void fillCreateAccountForm() {
        fillInput(CreateAccountInput.FIRST_NAME, customerModel.firstName);
        fillInput(CreateAccountInput.LAST_NAME, customerModel.lastName);
        fillInput(CreateAccountInput.EMAIL, customerModel.email);
        fillInput(CreateAccountInput.TELEPHONE, customerModel.phone);
        fillInput(CreateAccountInput.FAX, customerModel.fax);

        fillInput(CreateAccountInput.COMPANY, customerModel.company);
        fillInput(CreateAccountInput.ADDRESS1, customerModel.address1);
        fillInput(CreateAccountInput.ADDRESS2, customerModel.address2);
        fillInput(CreateAccountInput.CITY, customerModel.city);
        selectStateOrCountry(CreateAccountInput.REGION_STATE, customerModel.stateDefault);
        fillInput(CreateAccountInput.ZIPCODE, customerModel.zipCode);

        fillInput(CreateAccountInput.LOGIN_NAME, customerModel.login);
        fillInput(CreateAccountInput.PASSWORD, customerModel.password);
        fillInput(CreateAccountInput.CONFIRM_PASSWORD, customerModel.password);

        subscribeToNewsletter(accountModel.isSubscribedToNewsletter);
        acceptPrivacyPolicy();
    }
}
