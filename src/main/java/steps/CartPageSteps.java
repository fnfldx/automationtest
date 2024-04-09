package steps;


import models.ProductModel;
import org.junit.Assert;
import pages.cartPage.CartPage;

import java.util.List;

public class CartPageSteps {
    protected static CartPage cartPage;

    public static void updateCart() {
        cartPage = new CartPage();
        cartPage.clickOnUpdateButton();
    }

    public static void goToCheckout() {
        cartPage = new CartPage();
        cartPage.clickOnFinalCheckoutButton();
    }

    public static List<ProductModel> getProductsFromShoppingTable() {
        cartPage = new CartPage();
        return cartPage.shoppingCartTable.getProducts();
    }

    public static void checkIfProductAppearsOnce(ProductModel product, List<ProductModel> products) {
        var count = products
                .stream()
                .filter(p -> p.equals(product))
                .count();

        Assert.assertEquals(1, count);
    }
}
