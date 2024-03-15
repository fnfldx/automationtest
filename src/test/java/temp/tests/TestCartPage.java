package temp.tests;

import engine.drivers.WebDriverFactory;
import enums.BrowserName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.cartPage.CartPage;

import static engine.property.manager.PropertyManager.PropertyKeys.BASE_URL;
import static engine.property.manager.PropertyManager.getProperty;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;

public class TestCartPage {

    protected static CartPage cartPage;
    protected static BasePage basePage;

    @Before
    public void setUpBrowserAndDoRequiredSteps() {
        getPropertyManagerInstance();
        WebDriver driver = WebDriverFactory.getWebDriver(BrowserName.CHROME);

        // open a page
        String url = getProperty(BASE_URL);
        driver.navigate().to(url);

        // add first product to cart
        WebElement addProductToCart = driver.findElement(By.xpath("//*[@id='block_frame_latest_1770']/div/div[1]/div[2]/div[3]/a"));
        addProductToCart.click();

        // click cart
        WebElement goToCart = driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div[3]/ul/li/a"));
        goToCart.click();
        Assert.assertEquals("Cart URL is not valid", "https://automationteststore.com/index.php?rt=checkout/cart", driver.getCurrentUrl());
    }

    @Test
    public void cartPage() {

        // click update
        CartPage.clickOnUpdateButton();
        Assert.assertEquals("Login URL is not valid", "https://automationteststore.com/index.php?rt=account/logi", driver.getCurrentUrl());

        // click checkout
        CartPage.clickOnFinalCheckoutButton();
        Assert.assertEquals("Login URL is not valid", "https://automationteststore.com/index.php?rt=account/logi", driver.getCurrentUrl());
    }

    @After
    public void tearDown() {

        // close a page
        driver.quit();
    }
}


