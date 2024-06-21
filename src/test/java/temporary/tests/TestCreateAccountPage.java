package temporary.tests;

import models.AccountModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.createAccountPage.CreateAccountPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.openPage;
import static steps.CreateAccountPageSteps.fillCreateAccountForm;
import static steps.CreateAccountPageSteps.goToCreateAccountPage;
import static steps.CreateAccountPageSteps.submitCreateAccountForm;
import static steps.CreateAccountPageSteps.validateFirstNameInNavbar;

public class TestCreateAccountPage extends BaseTest {
    protected static CreateAccountPage createAccountPage;

    @BeforeAll
    public static void setUp() {
        createAccountPage = new CreateAccountPage();
    }

    @AfterEach
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    @Tag("EndToEnd")
    public void createAccount() {
        // Given:
        var accountModel = AccountModel.withRandomCustomerModel();
        openPage();
        goToCreateAccountPage();
        // When:
        fillCreateAccountForm(accountModel);
        submitCreateAccountForm();
        // Then:
        validateFirstNameInNavbar(accountModel.customerModel.firstName);
    }
}