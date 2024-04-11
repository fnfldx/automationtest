package steps;

import models.AccountModel;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.createAccountPage.AccountFormUtils;
import pages.createAccountPage.CreateAccountInput;
import pages.createAccountPage.CreateAccountPage;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static steps.LoginPageSteps.goToAccountLogin;
import static steps.LoginPageSteps.proceedAsRegisterAccount;

public class CreateAccountPageSteps {
    protected static AccountFormUtils accountFormUtils;
    protected static CreateAccountPage createAccountPage;

    public static void goToCreateAccountPage() {
        goToAccountLogin();
        proceedAsRegisterAccount();
    }

    public static void fillCreateAccountForm(AccountModel accountModel) {
        accountFormUtils = new AccountFormUtils();
        var customerModel = accountModel.customerModel;

        //Form: Your Personal Details
        accountFormUtils.fillInput(CreateAccountInput.FIRST_NAME, customerModel.firstName);
        accountFormUtils.fillInput(CreateAccountInput.LAST_NAME, customerModel.lastName);
        accountFormUtils.fillInput(CreateAccountInput.EMAIL, customerModel.email);
        accountFormUtils.fillInput(CreateAccountInput.TELEPHONE, customerModel.phone);
        accountFormUtils.fillInput(CreateAccountInput.FAX, customerModel.fax);

        //Form: Your Address
        accountFormUtils.fillInput(CreateAccountInput.COMPANY, customerModel.company);
        accountFormUtils.fillInput(CreateAccountInput.ADDRESS1, customerModel.address1);
        accountFormUtils.fillInput(CreateAccountInput.ADDRESS2, customerModel.address2);
        accountFormUtils.fillInput(CreateAccountInput.CITY, customerModel.city);
        accountFormUtils.selectStateOrCountry(CreateAccountInput.REGION_STATE, customerModel.state);
        accountFormUtils.fillInput(CreateAccountInput.ZIPCODE, customerModel.zipCode);

        //Form: Login Details
        accountFormUtils.fillInput(CreateAccountInput.LOGIN_NAME, accountModel.loginName);
        accountFormUtils.fillInput(CreateAccountInput.PASSWORD, accountModel.password);
        accountFormUtils.fillInput(CreateAccountInput.CONFIRM_PASSWORD, accountModel.password);

        //Form: Newsletter
        accountFormUtils.subscribeToNewsletter(accountModel.isSubscribedToNewsletter);
        accountFormUtils.acceptPrivacyPolicy();
    }

    public static void submitCreateAccountForm() {
        createAccountPage = new CreateAccountPage();
        createAccountPage.clickContinueButton();
    }

    public static void validateFirstNameInNavbar(String loginName) {
        var welcomeMessage = getWebDriverInstance().findElement(By.xpath("//ul[@id='customer_menu_top']//div"));
        Assert.assertTrue(welcomeMessage.getText().contains(loginName));
    }
}
