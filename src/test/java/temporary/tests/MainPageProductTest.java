package temporary.tests;

import org.junit.jupiter.api.Test;
import pages.mainpage.MainPageProduct;
import pages.mainpage.MainPageSection;
import enums.MainPageSectionId;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageProductTest {

    @Test
    public void testAddProductToCart() {
        MainPageSection mainPageSection = new MainPageSection(MainPageSectionId.FEATURES);
        MainPageProduct mainPageProduct = mainPageSection.getProduct(50);

        String productName = mainPageProduct.getProductName();
        double productPrice = mainPageProduct.getPrice();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);

        mainPageProduct.clickAddToCartButton();
    }
}