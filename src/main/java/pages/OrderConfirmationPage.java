package pages;

import org.openqa.selenium.By;

public class OrderConfirmationPage {
    protected BasePage basePage;

    // Locators:
    public By orderConfirmationMessageLocator = By.xpath("//*[@id='maincontainer']/div/div/div/h1/span[1]");

    public OrderConfirmationPage() {
        this.basePage = new BasePage;
    }

    public boolean hasOrderBeenProceesedSuccessfully() {
        return basePage.isElementDisplayed(orderConfirmationMessageLocator) &&
                basePage.getTextFromElement(orderConfirmationMessageLocator).matches(".*YOUR ORDER HAS BEEN PROCESSED.*");
    }
}