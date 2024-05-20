package temporary.tests;

import org.junit.After;
import org.junit.Test;
import enums.MainPageSectionId;
import pages.mainPage.MainPageProduct;
import pages.mainPage.MainPageSection;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.openPage;

public class MainPageProductTest extends BaseTest {

    @After
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    public void testAddProductToCartInStock() {
        openPage();
        MainPageSection mainPageSection = new MainPageSection(MainPageSectionId.FEATURES);
        MainPageProduct mainPageProduct = mainPageSection.getProduct(3);

        var productsDetails = mainPageProduct.getProductsDetails();

        System.out.println("Product Name: " + productsDetails.name);
        System.out.println("Product Price: " + productsDetails.price);

        mainPageProduct.clickAddToCartButton();
    }

    @Test
    public void testAddProductToCartOutOfStock() {
        openPage();
        MainPageSection mainPageSection = new MainPageSection(MainPageSectionId.FEATURES);
        MainPageProduct mainPageProduct = mainPageSection.getProduct(1);

        var productsDetails = mainPageProduct.getProductsDetails();

        System.out.println("Product Name: " + productsDetails.name);
        System.out.println("Product Price: " + productsDetails.price);

        mainPageProduct.clickAddToCartButton();
    }
}