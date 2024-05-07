package pages;

import org.openqa.selenium.By;

public class OrderConfirmationPage {
    protected BasePage basePage;

    // Locators:
    public By orderConfirmationMessageLocator = By.xpath("//h1[contains(text(), 'YOUR ORDER HAS BEEN PROCESSED')]");

    public OrderConfirmationPage() {
        this.basePage = new BasePage();
    }

    public boolean isOrderConfirmationMessageVisible() {
        return basePage.isElementDisplayed(orderConfirmationMessageLocator);
    }

    public boolean doesOrderConfirmationMessageContainExpectedText() {
        return basePage.getTextFromElement(orderConfirmationMessageLocator).matches(".*YOUR ORDER HAS BEEN PROCESSED.*");
    }
}