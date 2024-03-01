package pages;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Contract("_ -> new")
    private @NotNull By addToCartButtonByProduct(int productId) {
        return By.cssSelector("a[data-id='" + productId + "']");
    }

    public void addProductToCart(int productId) {
        By locator = addToCartButtonByProduct(productId);
        clickOnElement(locator);

    }
}