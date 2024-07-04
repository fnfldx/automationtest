package temporary.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import enums.MainPageSectionId;
import pages.mainPage.MainPageSection;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.openPage;

public class MainPageProductTest extends BaseTest {
    @AfterEach
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    public void testAddProductToCartInStock() {
        openPage();
        var mainPageSection = new MainPageSection(MainPageSectionId.FEATURES);
        var mainPageProduct = mainPageSection.getProduct(3);

        var productsDetails = mainPageProduct.getProductsDetails();

        mainPageProduct.clickAddToCartButton();
    }

    @Test
    public void testAddProductToCartOutOfStock() {
        openPage();
        var mainPageSection = new MainPageSection(MainPageSectionId.FEATURES);
        var mainPageProduct = mainPageSection.getProduct(1);

        var productsDetails = mainPageProduct.getProductsDetails();

        mainPageProduct.clickAddToCartButton();
    }

}