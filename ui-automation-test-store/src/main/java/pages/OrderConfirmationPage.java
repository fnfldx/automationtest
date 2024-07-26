package pages;

import org.openqa.selenium.By;

public class OrderConfirmationPage {
    // Locators:
    public By orderConfirmationMessageLocator = By.xpath("//body[@class='checkout-success']//span[contains(@class, 'maintext')]");
    public By invoicePageHyperlinkLocator = By.xpath("(//body[@class='checkout-success']//div[@class='contentpanel']//a)[1]");
    public By contactPageHyperlinkLocator = By.xpath("(//body[@class='checkout-success']//div[@class='contentpanel']//a)[2]");
    public By continueButtonLocator = By.xpath("(//body[@class='checkout-success']//div[@class='contentpanel']//a)[3]");

    protected BasePage basePage;

    public OrderConfirmationPage() {
        this.basePage = new BasePage();
    }

    public void navigateToInvoicePage() {
        basePage.clickOnElement(invoicePageHyperlinkLocator);
    }

    public void navigateToContactPage() {
        basePage.clickOnElement(contactPageHyperlinkLocator);
    }

    public void navigateToContinueShopping() {
        basePage.clickOnElement(continueButtonLocator);
    }

    public boolean isOrderConfirmationMessageVisible() {
        return basePage.isElementDisplayed(orderConfirmationMessageLocator);
    }

    public boolean doesOrderConfirmationMessageContainExpectedText() {
        return basePage.getTextFromElement(orderConfirmationMessageLocator).matches(".*YOUR ORDER HAS BEEN PROCESSED.*");
    }
}