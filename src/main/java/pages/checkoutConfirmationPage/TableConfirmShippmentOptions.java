package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class TableConfirmShippmentOptions {

    protected BasePage basePage;

    public By editShippingButtonLocator = By.xpath("//a[normalize-space()='Edit Shipping']");

    public TableConfirmShippmentOptions() {
        this.basePage = new BasePage();
    }

    public void clickOnEditShippingButton() {
        basePage.clickOnElement(editShippingButtonLocator);
    }


}
