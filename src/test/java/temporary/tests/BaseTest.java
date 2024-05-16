package temporary.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;
import static steps.BaseSteps.openPage;
import static steps.BaseSteps.validateNewTabURL;
import static steps.BaseSteps.clickOnFacebookHeaderButton;
import static steps.BaseSteps.clickOnTwitterHeaderButton;
import static steps.BaseSteps.clickOnLinkedinHeaderButton;
import static steps.BaseSteps.clickOnFacebookFooterButton;
import static steps.BaseSteps.clickOnTwitterFooterButton;
import static steps.BaseSteps.clickOnLinkedinFooterButton;

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
    public void checkFacebookHeaderRedirect(){
        openPage();

        clickOnFacebookHeaderButton();

        var tabs = getWebDriverInstance().getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://www.facebook.com/");
    }

    @Test
    public void checkFacebookFooterRedirect(){
        openPage();

        clickOnFacebookFooterButton();

        var tabs = getWebDriverInstance().getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://www.facebook.com/");
    }

    @Test
    public void checkTwitterHeaderRedirect(){
        openPage();

        clickOnTwitterHeaderButton();

        var tabs = getWebDriverInstance().getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://twitter.com/");
    }

    @Test
    public void checkTwitterFooterRedirect(){
        openPage();

        clickOnTwitterFooterButton();

        var tabs = getWebDriverInstance().getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://twitter.com/");
    }

    @Test
    public void checkLinkedinHeaderRedirect(){
        openPage();

        clickOnLinkedinHeaderButton();

        var tabs = getWebDriverInstance().getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://www.linkedin.com/");
    }

    @Test
    public void checkLinkedinFooterRedirect(){
        openPage();

        clickOnLinkedinFooterButton();

        var tabs = getWebDriverInstance().getWindowHandles();
        Assert.assertEquals("New tab is not opened", 2, tabs.size());
        validateNewTabURL("https://www.linkedin.com/");
    }
}