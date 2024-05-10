package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.cartPage.CartPage;

import java.time.Duration;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.property.manager.PropertyManager.PropertyKeys.BASE_URL;
import static engine.property.manager.PropertyManager.getProperty;

public class BaseSteps {

    protected static CartPage cartPage;

    public static void openPage() {
        var driver = getWebDriverInstance();
        var url = getProperty(BASE_URL);
        driver.get(url);

        var welcomeMsg = By.xpath("//div[@class='welcome_msg']");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));

        validateURL(url);
    }

    public static void addToCart() {
        var addProductToCart = getWebDriverInstance().findElement(By.xpath("//*[@id='block_frame_latest_1770']/div/div[1]/div[2]/div[3]/a"));
        addProductToCart.click();
    }

    public static void addProductToCartById(String id) {
        cartPage = new CartPage();
        String xpath = String.format("//a[@data-id='%s']", id);
        By productLocator = By.xpath(xpath);
        if (cartPage.getBasePage().isElementDisplayed(productLocator)) {
            cartPage.getBasePage().clickOnElement(productLocator);
        } else {
            Assert.fail("Product with id " + id + " was not found");
        }
    }

    public static void goToCart() {
        var goToCart = getWebDriverInstance().findElement(By.xpath("/html/body/div/header/div[2]/div/div[3]/ul/li/a"));
        goToCart.click();

        validateURL("https://automationteststore.com/index.php?rt=checkout/cart");
    }

    public static void validateURL(String url) {
        Assert.assertEquals("Guest Checkout URL is not valid", url, getWebDriverInstance().getCurrentUrl());
    }

    public static void validateNewTabURL(String expectedUrl) {
        var driver = getWebDriverInstance();
        var windowHandles = driver.getWindowHandles();
        var newTabHandle = windowHandles.stream()
                .filter(handle -> !handle.equals(driver.getWindowHandle()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("New tab did not open"));
        driver.switchTo().window(newTabHandle);
        var actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL is not valid", expectedUrl, actualUrl);
    }

    public static void clickOnFacebookButton() {
        var base = new BasePage();
        base.clickOnFacebookButton();
    }

    public static void clickOnTwitterButton() {
        var base = new BasePage();
        base.clickOnTwitterButton();
    }

    public static void clickOnLinkedinButton() {
        var base = new BasePage();
        base.clickOnLinkedinButton();
    }
}
