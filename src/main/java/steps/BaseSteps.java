package steps;

import enums.Currency;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.cartPage.CartPage;

import static engine.cookie.manager.CookieManager.getCookieManagerInstance;
import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.property.manager.PropertyManager.PropertyKeys.BASE_URL;
import static engine.property.manager.PropertyManager.getProperty;

public class BaseSteps {

    protected static CartPage cartPage;

    public static void openPage() {
        var driver = getWebDriverInstance();
        var url = getProperty(BASE_URL);
        driver.get(url);
    }

    public static void addToCart() {
        var addProductToCart = getWebDriverInstance().findElement(By.xpath("//*[@id='block_frame_latest_1770']/div/div[2]/div[2]/div[3]/a"));
        addProductToCart.click();
    }

    public static void addProductToCartById(String id) {
        var cartPage = new CartPage();
        String xpath = String.format("//a[@data-id='%s']", id);
        By productLocator = By.xpath(xpath);
        if (cartPage.basePage.isElementDisplayed(productLocator)) {
            cartPage.basePage.clickOnElement(productLocator);
        } else {
            Assert.fail("Product with id " + id + " was not found");
        }
    }

    public static void goToCart() {
        var goToCart = getWebDriverInstance().findElement(By.xpath("/html/body/div/header/div[2]/div/div[3]/ul/li/a"));
        goToCart.click();

        validateURL("https://automationteststore.com/index.php?rt=checkout/cart");
    }

    public static void setGlobalCurrencyAndRefresh(Currency currency) {
        getCookieManagerInstance().setGlobalCurrency(currency);
        getWebDriverInstance().navigate().refresh();
    }

    public static void validateGlobalCurrency(Currency currency) {
        var basePage = new BasePage();
        Assert.assertEquals("Currency is not set correctly", currency, basePage.getCurrencyFromPage());
    }

    public static void validateURL(String url) {
        Assert.assertEquals("Guest Checkout URL is not valid", url, getWebDriverInstance().getCurrentUrl());
    }

    public static void validateURLContains(String expectedURLPart) {
        String currentURL = getWebDriverInstance().getCurrentUrl();
        Assert.assertTrue("Current URL does not contain the expected part: " + expectedURLPart,
                currentURL.contains(expectedURLPart));
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

    public static void clickOnFacebookHeaderButton() {
        var basePage = new BasePage();
        basePage.clickOnElement(basePage.facebookHeaderButtonLocator);
    }

    public static void clickOnFacebookFooterButton() {
        var basePage = new BasePage();
        basePage.scrollToElement(basePage.facebookFooterButtonLocator);
        basePage.clickOnElement(basePage.facebookFooterButtonLocator);
    }

    public static void clickOnTwitterHeaderButton() {
        var basePage = new BasePage();
        basePage.clickOnElement(basePage.twitterHeaderButtonLocator);
    }

    public static void clickOnTwitterFooterButton() {
        var basePage = new BasePage();
        basePage.scrollToElement(basePage.twitterFooterButtonLocator);
        basePage.clickOnElement(basePage.twitterFooterButtonLocator);
    }

    public static void clickOnLinkedinHeaderButton() {
        var basePage = new BasePage();
        basePage.clickOnElement(basePage.linkedinHeaderButtonLocator);
    }

    public static void clickOnLinkedinFooterButton() {
        var basePage = new BasePage();
        basePage.scrollToElement(basePage.linkedinFooterButtonLocator);
        basePage.clickOnElement(basePage.linkedinFooterButtonLocator);
    }
}