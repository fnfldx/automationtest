package steps;

import models.AccountModel;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.createAccountPage.CreateAccountInput;
import pages.createAccountPage.CreateAccountPage;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static pages.createAccountPage.CreateAccountPage.address1;
import static pages.createAccountPage.CreateAccountPage.address2;
import static pages.createAccountPage.CreateAccountPage.city;
import static pages.createAccountPage.CreateAccountPage.company;
import static pages.createAccountPage.CreateAccountPage.confirmPassword;
import static pages.createAccountPage.CreateAccountPage.email;
import static pages.createAccountPage.CreateAccountPage.fax;
import static pages.createAccountPage.CreateAccountPage.firstName;
import static pages.createAccountPage.CreateAccountPage.lastName;
import static pages.createAccountPage.CreateAccountPage.loginName;
import static pages.createAccountPage.CreateAccountPage.password;
import static pages.createAccountPage.CreateAccountPage.regionState;
import static pages.createAccountPage.CreateAccountPage.telephone;
import static pages.createAccountPage.CreateAccountPage.zipCode;
import static steps.LoginPageSteps.goToAccountLogin;
import static steps.LoginPageSteps.proceedAsRegisterAccount;

public class CreateAccountPageSteps {
    protected static CreateAccountPage createAccountPage;

    public static void goToCreateAccountPage() {
        goToAccountLogin();
        proceedAsRegisterAccount();
    }

    public static void fillCreateAccountForm(AccountModel accountModel) {
        createAccountPage = new CreateAccountPage();
        var customerModel = accountModel.customerModel;

        //Form: Your Personal Details
        firstName.fillInput(customerModel.firstName);
        lastName.fillInput(customerModel.lastName);
        email.fillInput(customerModel.email);
        telephone.fillInput(customerModel.phone);
        fax.fillInput(customerModel.fax);

        //Form: Your Address
        company.fillInput(customerModel.company);
        address1.fillInput(customerModel.address1);
        address2.fillInput(customerModel.address2);
        city.fillInput(customerModel.city);
        regionState.selectStateOrCountry(customerModel.state);
        zipCode.fillInput(customerModel.zipCode);

        //Form: Login Details
        loginName.fillInput(accountModel.loginName);
        password.fillInput(accountModel.password);
        confirmPassword.fillInput(accountModel.password);

        //Form: Newsletter
        createAccountPage.subscribeToNewsletter(accountModel.isSubscribedToNewsletter);
        createAccountPage.acceptPrivacyPolicy();
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