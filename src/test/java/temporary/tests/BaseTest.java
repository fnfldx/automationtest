package temporary.tests;

import enums.Currency;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

    @BeforeClass
    public static void baseClassSetUp() {
        getPropertyManagerInstance();
    }

    @Before
    public void baseSetUp() {
        getWebDriverInstance();
        openPage();
        getCookieManagerInstance().setCookiesFromProperties();
    }

    @AfterClass
    public static void baseTearDown() {
        quitWebDriver();
    }

    @Test
    public void setGlobalCurrency(){
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