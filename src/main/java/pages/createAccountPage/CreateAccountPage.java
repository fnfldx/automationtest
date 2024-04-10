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

    public By accountFormLocator = By.id("AccountFrm");
    public String alertMessageXpath = "//div[contains(@class, 'alert-error')]";
    public By alertMessageLocator = By.xpath(alertMessageXpath);
    public By alertMessageCloseButtonLocator = By.xpath(alertMessageXpath + "//button[@class='close']");
    public By continueButtonLocator = By.xpath("//button[@title='Continue']");
    public By loginPageLinkLocator = By.xpath("//p/a");

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
}
