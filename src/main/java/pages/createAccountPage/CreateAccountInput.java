package pages.createAccountPage;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import pages.BasePage;

@Getter
@Setter
public class CreateAccountInput {
    protected BasePage basePage;
    protected CreateAccountFormId input;

    public CreateAccountInput(CreateAccountFormId input) {
        this.basePage = new BasePage();
        this.input = input;
    }

    public Boolean isRequiredSymbolForInputDisplayed() {
        return basePage.isElementDisplayed(By.xpath("//input[@id='" + input.getId() + "']/parent::div//span[@class='required']"));
    }

    public String getHelpTextForInput() {
        return basePage.getTextFromElement(inputHelpTextLocator());
    }

    public void selectStateOrCountry(String value) {
        var element = inputFormLocator();
        basePage.selectionOptionFromDropdown(element, value);
    }

    public void fillInput(String value) {
        basePage.enterTextToElement(inputFormLocator(), value);
    }

    private By inputFormLocator() {
        return By.id(input.getId());
    }

    private By inputHelpTextLocator() {
        return By.xpath("//input[@id='" + input.getId() + "']/ancestor::div/span[@class='help-block']");
    }
}