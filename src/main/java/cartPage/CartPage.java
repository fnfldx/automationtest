package cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CartPage {

    protected WebDriver driver;
    public By updateButtonLocator = By.id("cart_update");
    public By checkoutButtonLocator = By.id("cart_checkout1");
    public By continueShoppingButtonLocator = By.xpath("//a[@class='btn btn-default mr10  mb10']");
    public By finalCheckoutButtonLocator = By.id("cart_checkout2");

    BasePage basePage = new BasePage(driver);

    void clickOnUpdateButton() {
        basePage.clickOnElement(updateButtonLocator);
    }

    void clickOnFinalCheckoutButton() {
        basePage.clickOnElement(finalCheckoutButtonLocator);
    }
}
