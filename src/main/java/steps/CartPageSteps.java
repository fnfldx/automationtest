package steps;


import models.CheckoutProductModel;
import models.ProductModel;
import org.junit.Assert;
import pages.cartPage.CartPage;
import pages.cartPage.shoppingCartTable.ShoppingCartTableRow;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

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

    public static void removeProductFromShoppingCartTable(CheckoutProductModel checkoutProduct) {
        cartPage = new CartPage();
        var shoppingCartTableRow = new ShoppingCartTableRow(cartPage.shoppingCartTable
                .getCheckoutProducts()
                .indexOf(checkoutProduct) + 1);
        shoppingCartTableRow.removeProduct();
    }

    public static void changeQuantityOfProduct(ProductModel product, int quantity) {
        cartPage = new CartPage();
        var shoppingCartTableRow = new ShoppingCartTableRow(cartPage.shoppingCartTable
                .getProducts()
                .indexOf(product) + 1);
        shoppingCartTableRow.setQuantity(quantity);
    }

    public static void checkIfCartIsEmpty() {
        cartPage = new CartPage();
        Assert.assertTrue(cartPage.shoppingCartTable.isCartEmpty());
    }

    public static void checkIfProductAppearsOnce(ProductModel product, List<CheckoutProductModel> checkoutProducts) {
        var count = checkoutProducts.stream()
                .filter(p -> p.getProductModel().equals(product))
                .count();
        Assert.assertEquals(1, count);
    }

    public static void checkIfTotalPriceIsCorrect(List<ProductModel> products, List<CheckoutProductModel> checkoutProducts) {
        var unitPrices = products.stream()
                .map(ProductModel::getPrice)
                .toList();
        var quantities = checkoutProducts.stream()
                .map(CheckoutProductModel::getQuantity)
                .toList();
        var totalPrices = checkoutProducts.stream()
                .map(CheckoutProductModel::getTotalPrice)
                .toList();
        var expectedTotalPrices = IntStream.range(0, products.size())
                .mapToObj(i -> unitPrices.get(i).multiply(BigDecimal.valueOf(quantities.get(i))))
                .toList();
        Assert.assertEquals(expectedTotalPrices, totalPrices);
    }
}