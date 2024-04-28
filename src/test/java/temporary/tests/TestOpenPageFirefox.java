package temporary.tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.setCookies;
import static engine.property.manager.PropertyManager.PropertyKeys.BASE_URL;
import static engine.property.manager.PropertyManager.getProperty;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;

public class TestOpenPageFirefox {
    @Test
    public void openPage() {
        getPropertyManagerInstance();
        WebDriver driver = getWebDriverInstance();
        LoginPage loginPage = new LoginPage();
        String url = getProperty(BASE_URL);
        driver.navigate().to(url);

        setCookies();
        driver.navigate().refresh();
        var welcomeMsg = By.xpath("//div[@class='welcome_msg']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));

        Assert.assertEquals(url, driver.getCurrentUrl());

        driver.quit();
    }
}