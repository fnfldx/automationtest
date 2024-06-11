package steps;

import enums.MainPageSectionId;
import pages.mainPage.MainPageSection;

public class MainPageSteps {
    protected static MainPageSection mainPage;

    public static void addProductToCart(MainPageSectionId sectionId, int productIndex) {
        mainPage = new MainPageSection(MainPageSectionId.FEATURES);
        var mainPageProduct = mainPage.getProduct(productIndex);
        mainPageProduct.clickAddToCartButton();
    }
}