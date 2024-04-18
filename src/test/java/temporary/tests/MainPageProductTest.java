package temporary.tests;

import org.junit.jupiter.api.Test;
import pages.mainpage.MainPageProduct;
import pages.mainpage.MainPageSection;
import enums.MainPageSectionId;

import static org.junit.jupiter.api.Assertions.*;
import static steps.BaseSteps.openPage;

public class MainPageProductTest {

    @Test
    public void testAddProductToCart() {
        openPage();
        MainPageSection mainPageSection = new MainPageSection(MainPageSectionId.FEATURES);
        MainPageProduct mainPageProduct = mainPageSection.getProduct(1);

        var productsDetails = mainPageProduct.getProductsDetails();

        System.out.println("Product Name: " + productsDetails.name);
        System.out.println("Product Price: " + productsDetails.price);

        mainPageProduct.clickAddToCartButton();
    }
}