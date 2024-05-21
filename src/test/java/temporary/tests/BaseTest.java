package temporary.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;

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
    }
}