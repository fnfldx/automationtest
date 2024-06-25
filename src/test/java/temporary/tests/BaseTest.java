package temporary.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static engine.cookie.manager.CookieManager.getCookieManagerInstance;
import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;
import static enums.Currency.EUR;
import static enums.Currency.GBP;
import static enums.Currency.USD;
import static steps.BaseSteps.clickOnFacebookFooterButton;
import static steps.BaseSteps.clickOnFacebookHeaderButton;
import static steps.BaseSteps.clickOnLinkedinFooterButton;
import static steps.BaseSteps.clickOnLinkedinHeaderButton;
import static steps.BaseSteps.clickOnTwitterFooterButton;
import static steps.BaseSteps.clickOnTwitterHeaderButton;
import static steps.BaseSteps.openPage;
import static steps.BaseSteps.setGlobalCurrencyAndRefresh;
import static steps.BaseSteps.validateGlobalCurrency;
import static steps.BaseSteps.validateNewTabURL;

public class BaseTest {

    @BeforeAll
    public static void baseClassSetUp() {
        getPropertyManagerInstance();
    }

    @AfterAll
    public static void baseTearDown() {
        quitWebDriver();
    }

    @BeforeEach
    public void baseSetUp() {
        getWebDriverInstance();
        openPage();
        getCookieManagerInstance().setCookiesFromProperties();
    }

    @Test
    public void setGlobalCurrency() {
        // Given:
        openPage();
        // When and Then:
        setGlobalCurrencyAndRefresh(EUR);
        validateGlobalCurrency(EUR);
        setGlobalCurrencyAndRefresh(GBP);
        validateGlobalCurrency(GBP);
        setGlobalCurrencyAndRefresh(USD);
        validateGlobalCurrency(USD);
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