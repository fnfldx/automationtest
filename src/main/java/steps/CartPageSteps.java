package steps;


import models.CheckoutProductModel;
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

    public static List<ProductModel> getProductsFromShoppingCartTable() {
        cartPage = new CartPage();
        return cartPage.shoppingCartTable.getProducts();
    }

    public static List<CheckoutProductModel> getCheckoutProductsFromShoppingCartTable() {
        cartPage = new CartPage();
        return cartPage.shoppingCartTable.getCheckoutProducts();
    }

    public static void checkIfProductAppearsOnce(ProductModel product, List<CheckoutProductModel> checkoutProducts) {
        var count = checkoutProducts.stream()
                .filter(p -> p.getProductModel().equals(product))
                .count();

        Assert.assertEquals(1, count);
    }
}
