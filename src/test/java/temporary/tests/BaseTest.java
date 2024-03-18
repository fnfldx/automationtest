package temporary.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;

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
}