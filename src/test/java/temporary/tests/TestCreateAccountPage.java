package temporary.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.createAccountPage.CreateAccountPage;

import static steps.BaseSteps.openPage;
import static steps.CreateAccountPageSteps.goToCreateAccountPage;
import static steps.CreateAccountPageSteps.validateFirstNameInNavbar;

public class TestCreateAccountPage extends BaseTest {
    protected static CreateAccountPage createAccountPage;

    @BeforeClass
    public static void setUp() {
        createAccountPage = new CreateAccountPage();
    }

    @Test
    public void createAccount() {
        // Given:
        openPage();
        goToCreateAccountPage();
        // When:
        createAccountPage.fillCreateAccountForm();
        createAccountPage.clickContinueButton();
        // Then:
        validateFirstNameInNavbar(createAccountPage.getAccountModel().customerModel.firstName);
    }
}
