package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class TableConfirmProducts {

    public By editCartButtonLocator = By.xpath("//i[contains(@class, 'fa-shopping-cart')]/parent::a");
    protected BasePage basePage;

    public TableConfirmProducts() {
        this.basePage = new BasePage();
    }

    public void clickOnEditCartButton() {
        basePage.clickOnElement(editCartButtonLocator);
    }
}