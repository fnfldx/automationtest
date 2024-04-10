package pages.createAccountPage;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import pages.BasePage;

@Getter
@Setter
public class CreateAccountPage {
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
}