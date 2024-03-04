package tests;

import engine.drivers.WebDriverFactory;
import enums.BrowserName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ShoppingCartTable;

import java.time.Duration;
import java.util.List;

import static engine.property.manager.PropertyManager.PropertyKeys.BASE_URL;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;
import static engine.property.manager.PropertyManager.getProperty;

public class TestOpenPageChrome {
    @Test
    public void openPage() {
        getPropertyManagerInstance();
        WebDriver driver = WebDriverFactory.getWebDriver(BrowserName.CHROME);

        String url = getProperty(BASE_URL);
        driver.navigate().to(url);

        var welcomeMsg = By.xpath("//div[@class='welcome_msg']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));

        Assert.assertEquals(url, driver.getCurrentUrl());

        driver.quit();
    }

    @Test
    public void testForDebugging() {
        System.out.println("This is a test for debugging");
        getPropertyManagerInstance();
        WebDriver driver = WebDriverFactory.getWebDriver(BrowserName.CHROME);

        String url = getProperty(BASE_URL);
        driver.navigate().to(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        var cartTable = new ShoppingCartTable(driver);
        int debug = cartTable.getRowCount();
        int debug2 = cartTable.getColumnCount();
        int debug3 = cartTable.getColumnIndex("Name");
        var debug4 = cartTable.getColumnHeaders();
        var debug5 = cartTable.getRowIndex("Benefit Bella Bamba");
        var debug6 = cartTable.getRowNumber("Benefit Bella Bamba");
        var debug7 = cartTable.getRowContent(2);
        var debug8 = cartTable.getColumnContent(3);
        var debug9 = cartTable.getColumnContent("Quantity");
        var debug10 = cartTable.getCellContent(3, 3);
        var debug11 = cartTable.getCellContent(3, "Name");

        var debug12 = cartTable.getUnitPriceWithCurrencyCharacter(1);
        var debug13 = cartTable.getUnitPrice(1);

        driver.quit();
    }
}