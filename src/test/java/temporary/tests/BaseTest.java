package temporary.tests;

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
import static steps.BaseSteps.openPage;
import static steps.BaseSteps.setGlobalCurrencyAndRefresh;
import static steps.BaseSteps.validateGlobalCurrency;

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
}