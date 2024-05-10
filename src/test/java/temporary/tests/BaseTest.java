package temporary.tests;

import org.junit.*;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;
import static steps.BaseSteps.*;

public class BaseTest {

    @BeforeClass
    public static void baseClassSetUp() {
        getPropertyManagerInstance();
    }

    @Before
    public void baseSetUp() {
        getWebDriverInstance();
    }

    @AfterClass
    public static void baseTearDown() {
        quitWebDriver();
    }

    @Test
    public void checkFacebookRedirect(){
        // Given
        openPage();
        // When
        clickOnFacebookButton();
        // Then
        var driver = getWebDriverInstance();
        var tabs = driver.getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://facebook.com/");
    }

    @Test
    public void checkTwitterRedirect(){
        // Given
        openPage();
        // When
        clickOnTwitterButton();
        // Then
        var driver = getWebDriverInstance();
        var tabs = driver.getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());

        validateNewTabURL("https://twitter.com/");
    }

    @Test
    public void checkLinkedinRedirect(){
        // Given
        openPage();
        // When
        clickOnLinkedinButton();
        // Then
        var driver = getWebDriverInstance();
        var tabs = driver.getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://linkedin.com/");
        // test nie przechodzi bo linkedin otwiera sie na tej samej karcie
    }

}