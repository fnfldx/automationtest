package steps;

import models.CheckoutProductModel;
import models.ProductModel;
import org.junit.Assert;
import pages.cartPage.CartPage;
import pages.cartPage.shoppingCartTable.ShoppingCartTableRow;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    public static void validateTotalPrice() {
        cartPage = new CartPage();
        var subTotalPrice = cartPage.totalsTable.getSubTotalPrize();
        var shippingPrice = cartPage.totalsTable.getFlatShippingRatePrize();
        var totalPrice = cartPage.totalsTable.getTotalPrize();
        assertThat(totalPrice).isEqualTo(subTotalPrice.add(shippingPrice));
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

    public static void checkIfTotalPricesAreCorrectPerProduct(List<ProductModel> products, List<CheckoutProductModel> checkoutProducts) {
        checkoutProducts.forEach(checkoutProduct -> {
            var product = getProductByCheckoutProduct(products, checkoutProduct);
            var expectedTotalPrice = product.getPrice().multiply(BigDecimal.valueOf(checkoutProduct.getQuantity()));
            Assert.assertEquals(expectedTotalPrice, checkoutProduct.getTotalPrice());
        });
    }

    public static ProductModel getProductByCheckoutProduct(List<ProductModel> products, CheckoutProductModel checkoutProduct) {
        return products.stream()
                .filter(product -> product.getName().equals(checkoutProduct.getProductModel().getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching product found for checkout product"));
    }
}