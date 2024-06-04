package pages.checkoutConfirmationPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class ConfirmShippmentOptionsTable {
    public final String confirmShippmentOptionsTableXpath = "//table[contains(@class,'confirm_shippment_options')]";
    public By editShippingButtonLocator = By.xpath(confirmShippmentOptionsTableXpath + "//a");
    protected BasePage basePage;

    public ConfirmShippmentOptionsTable() {
        this.basePage = new BasePage();
    }

    public void clickOnEditShippingButton() {
        basePage.clickOnElement(editShippingButtonLocator);
    }
}