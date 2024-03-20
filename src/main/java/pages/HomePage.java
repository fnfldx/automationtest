package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By addToCartButtonByProduct(int productId) {
        return By.cssSelector(String.format("a[data-id='%d']", productId));
    }
    public void addProductToCart(int productId) {
        By locator = addToCartButtonByProduct(productId);
        clickOnElement(locator);
    }
}