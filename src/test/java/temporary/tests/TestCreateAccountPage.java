package temporary.tests;

import models.AccountModel;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.createAccountPage.CreateAccountPage;

import static steps.BaseSteps.openPage;
import static steps.CreateAccountPageSteps.*;

public class TestCreateAccountPage extends BaseTest {
    protected static CreateAccountPage createAccountPage;

    @BeforeClass
    public static void setUp() {
        createAccountPage = new CreateAccountPage();
    }

    @Test
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