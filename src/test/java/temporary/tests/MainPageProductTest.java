package temporary.tests;


import org.junit.Test;
import pages.mainPage.MainPageProduct;
import pages.mainPage.MainPageSection;
import enums.MainPageSectionId;
import static steps.BaseSteps.openPage;

public class MainPageProductTest {

    @Test
    public void testAddProductToCart() {
        openPage();
        MainPageSection mainPageSection = new MainPageSection(MainPageSectionId.FEATURES);
        MainPageProduct mainPageProduct = mainPageSection.getProduct(3);

        var productsDetails = mainPageProduct.getProductsDetails();

        System.out.println("Product Name: " + productsDetails.name);
        System.out.println("Product Price: " + productsDetails.price);

        mainPageProduct.clickAddToCartButton();
    }}