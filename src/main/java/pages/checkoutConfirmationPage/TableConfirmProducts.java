package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class TableConfirmProducts {

    protected BasePage basePage;

    public By editCartButtonLocator = By.className("//a[contains(@class, 'pull-right mr10 btn btn-default btn-xs')]");

    public TableConfirmProducts() {
        this.basePage = new BasePage();
    }

    public void clickOnEditCartButton() {
        basePage.clickOnElement(editCartButtonLocator);
    }
}
