package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import pages.createAccountPage.CreateAccountPage;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static steps.LoginPageSteps.goToAccountLogin;
import static steps.LoginPageSteps.proceedAsRegisterAccount;

public class CreateAccountPageSteps {
    protected static CreateAccountPage createAccountPage;

    public static void goToCreateAccountPage() {
        goToAccountLogin();
        proceedAsRegisterAccount();
    }

    public static void fillCreateAccountForm() {
        createAccountPage = new CreateAccountPage();
        createAccountPage.fillCreateAccountForm();
    }

public static void validateFirstNameInNavbar(String loginName) {
        var welcomeMessage = getWebDriverInstance().findElement(By.xpath("//ul[@id='customer_menu_top']//div"));
        Assert.assertTrue(welcomeMessage.getText().contains(loginName));
    }
}
