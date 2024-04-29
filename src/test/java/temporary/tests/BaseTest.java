package temporary.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static engine.cookie.manager.CookieManager.setCookiesFromProperties;
import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;
import static steps.BaseSteps.openPage;

public class BaseTest {

    @BeforeClass
    public static void baseClassSetUp() {
        getPropertyManagerInstance();
    }

    @Before
    public void baseSetUp() {
        getWebDriverInstance();
        openPage();
        setCookiesFromProperties();
    }

    @AfterClass
    public static void baseTearDown() {
        quitWebDriver();
    }
}