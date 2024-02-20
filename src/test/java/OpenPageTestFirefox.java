import engine.drivers.WebDriverFactory;
import enums.BrowserName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OpenPageTestFirefox {
    @Test
    public void openPage() {
        WebDriver driver = WebDriverFactory.getWebDriver(BrowserName.FIREFOX);

        String url = "https://automationteststore.com/";
        driver.navigate().to(url);

        var welcomeMsg = By.xpath("//div[@class='welcome_msg']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));

        Assert.assertEquals(url, driver.getCurrentUrl());

        driver.quit();
    }
}
