package pages;

import org.openqa.selenium.By;

public class OrderConfirmationPage {
    protected BasePage basePage;

    // Locators:
    public By orderConfirmationMessageLocator = By.xpath("//h1[contains(text(), 'YOUR ORDER HAS BEEN PROCESSED')]");
    public By invoicePageHyperlinkLocator = By.xpath("//*[@id='maincontainer']/div/div/div/div/section/p[3]/a");
    public By contactWithStoreOwnerrHyperlinkLocator = By.xpath("//*[@id='maincontainer']/div/div/div/div/section/p[4]/a");
    public By continueButtonLocator = By.xpath("//*[@id='maincontainer']/div/div/div/div/section/a");


    public OrderConfirmationPage() {
        this.basePage = new BasePage();
    }

    public void goToInvoicePage() {
        basePage.clickOnElement(invoicePageHyperlinkLocator);
    }

    public void goToContactWithStoreOwner() {
        basePage.clickOnElement(contactWithStoreOwnerrHyperlinkLocator);
    }

    public void continueShopping() {
        basePage.clickOnElement(continueButtonLocator);
    }

    public boolean isOrderConfirmationMessageVisible() {
        return basePage.isElementDisplayed(orderConfirmationMessageLocator);
    }

    public boolean doesOrderConfirmationMessageContainExpectedText() {
        return basePage.getTextFromElement(orderConfirmationMessageLocator).matches(".*YOUR ORDER HAS BEEN PROCESSED.*");
    }
}