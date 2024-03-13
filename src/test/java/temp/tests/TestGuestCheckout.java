package temp.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.PropertyKeys.BASE_URL;
import static engine.property.manager.PropertyManager.getProperty;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;

public class TestGuestCheckout {
    protected static LoginPage loginPage;
    protected static BasePage basePage;

    @BeforeClass
    public static void setUp() {
        getPropertyManagerInstance();
        basePage = new BasePage();
        loginPage = new LoginPage();
    }

    @AfterClass
    public static void tearDown() {
        quitWebDriver();
    }

    @Test
    public void openPage() {
        String url = getProperty(BASE_URL);
        basePage.openUrl(url);

        var welcomeMsg = By.xpath("//div[@class='welcome_msg']");
        WebDriverWait wait = new WebDriverWait(basePage.driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));

        Assert.assertEquals(url, basePage.driver.getCurrentUrl());
    }

    @Test
    public void addToCartAndGoToCart() {
        openPage();

        WebElement addProductToCart = basePage.driver.findElement(By.xpath("//*[@id='block_frame_latest_1770']/div/div[1]/div[2]/div[3]/a"));
        addProductToCart.click();

        WebElement goToCart = basePage.driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[3]/ul/li/a"));
        goToCart.click();

        Assert.assertEquals("Cart URL is not valid", "https://automationteststore.com/index.php?rt=checkout/cart", basePage.driver.getCurrentUrl());
    }

    @Test
    public void goToCheckout() {
        addToCartAndGoToCart();

        WebElement goToCheckout = basePage.driver.findElement(By.xpath("//*[@id='cart_checkout2']"));
        goToCheckout.click();

        Assert.assertEquals("Login URL is not valid", "https://automationteststore.com/index.php?rt=account/login", basePage.driver.getCurrentUrl());
    }

    @Test
    public void continueAsGuest() {
        goToCheckout();

        if (isGuestCheckoutButtonVisible(basePage, loginPage.guestCheckoutButtonLocator)) {
            basePage.clickOnElement(loginPage.guestCheckoutButtonLocator);
            basePage.clickOnElement(loginPage.continueButtonLocator);
        } else {
            throw new NoSuchElementException("Guest Checkout button is not present when there are no items in the cart. You need to add at least one item to cart.");
        }

        Assert.assertEquals("Guest Checkout URL is not valid", "https://automationteststore.com/index.php?rt=checkout/guest_step_1", basePage.driver.getCurrentUrl());
    }

    public boolean isGuestCheckoutButtonVisible(BasePage basePage, By guestCheckoutButtonLocator) {
        return basePage.isElementDisplayed(guestCheckoutButtonLocator);
    }
}