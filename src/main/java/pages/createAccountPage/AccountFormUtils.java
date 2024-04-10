package pages.createAccountPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class AccountFormUtils {
    protected BasePage basePage;

    public AccountFormUtils() {
        this.basePage = new BasePage();
    }

    public By inputFormLocator(CreateAccountInput input) {
        return By.id(input.getId());
    }

    public By inputHelpTextLocator(CreateAccountInput input) {
        return By.xpath("//input[@id='" + input.getId() + "']/ancestor::div/span[@class='help-block']");
    }

    public Boolean isRequiredSymbolForInputDisplayed(CreateAccountInput input) {
        return basePage.isElementDisplayed(By.xpath("//input[@id='" + input.getId() + "']/parent::div//span[@class='required']"));
    }

    public String getHelpTextForInput(CreateAccountInput input) {
        return basePage.getTextFromElement(inputHelpTextLocator(input));
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

    public void fillInput(CreateAccountInput input, String value) {
        basePage.enterTextToElement(inputFormLocator(input), value);
    }
}
