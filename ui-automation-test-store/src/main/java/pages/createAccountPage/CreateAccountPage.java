package pages.createAccountPage;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import pages.BasePage;

import static pages.createAccountPage.CreateAccountFormId.*;

@Getter
@Setter
public class CreateAccountPage {
    public static CreateAccountInput firstName = new CreateAccountInput(FIRST_NAME);
    public static CreateAccountInput lastName = new CreateAccountInput(LAST_NAME);
    public static CreateAccountInput email = new CreateAccountInput(EMAIL);
    public static CreateAccountInput telephone = new CreateAccountInput(TELEPHONE);
    public static CreateAccountInput fax = new CreateAccountInput(FAX);
    public static CreateAccountInput company = new CreateAccountInput(COMPANY);
    public static CreateAccountInput address1 = new CreateAccountInput(ADDRESS1);
    public static CreateAccountInput address2 = new CreateAccountInput(ADDRESS2);
    public static CreateAccountInput city = new CreateAccountInput(CITY);
    public static CreateAccountInput regionState = new CreateAccountInput(REGION_STATE);
    public static CreateAccountInput zipCode = new CreateAccountInput(ZIPCODE);
    public static CreateAccountInput country = new CreateAccountInput(COUNTRY);
    public static CreateAccountInput loginName = new CreateAccountInput(LOGIN_NAME);
    public static CreateAccountInput password = new CreateAccountInput(PASSWORD);
    public static CreateAccountInput confirmPassword = new CreateAccountInput(CONFIRM_PASSWORD);
    public static CreateAccountInput subscribeYes = new CreateAccountInput(SUBSCRIBE_YES);
    public static CreateAccountInput subscribeNo = new CreateAccountInput(SUBSCRIBE_NO);
    public static CreateAccountInput privacyPolicy = new CreateAccountInput(PRIVACY_POLICY);
    public By accountFormLocator = By.id("AccountFrm");
    public String alertMessageXpath = "//div[contains(@class, 'alert-error')]";
    public By alertMessageLocator = By.xpath(alertMessageXpath);
    public By alertMessageCloseButtonLocator = By.xpath(alertMessageXpath + "//button[@class='close']");
    public By continueButtonLocator = By.xpath("//button[@title='Continue']");
    public By loginPageLinkLocator = By.xpath("//p/a");
    protected BasePage basePage;

    public CreateAccountPage() {
        this.basePage = new BasePage();
    }

    public String getAlertMessageText() {
        return basePage.getTextFromElement(alertMessageLocator);
    }

    public void closeAlertMessage() {
        basePage.clickOnElement(alertMessageCloseButtonLocator);
    }

    public void clickContinueButton() {
        basePage.clickOnElement(continueButtonLocator);
    }

    public void subscribeToNewsletter(boolean subscribe) {
        var id = subscribe ? SUBSCRIBE_YES.getId() : SUBSCRIBE_NO.getId();
        basePage.selectRadioButton(By.id(id));
    }

    public void acceptPrivacyPolicy() {
        basePage.selectCheckbox(By.id(PRIVACY_POLICY.getId()));
    }

    public void unselectPrivacyPolicy() {
        basePage.unselectCheckbox(By.id(PRIVACY_POLICY.getId()));
    }
}