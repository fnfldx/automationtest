package temporary.tests;

import enums.Currency;
import models.ProductModel;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.cartPage.CartPage;
import steps.BaseSteps;

import java.math.BigDecimal;
import java.util.ArrayList;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.addProductToCartById;
import static steps.BaseSteps.addToCart;
import static steps.BaseSteps.goToCart;
import static steps.BaseSteps.openPage;
import static steps.CartPageSteps.changeQuantityOfProduct;
import static steps.CartPageSteps.checkIfCartIsEmpty;
import static steps.CartPageSteps.checkIfProductAppearsOnce;
import static steps.CartPageSteps.checkIfTotalPricesAreCorrectPerProduct;
import static steps.CartPageSteps.getCheckoutProductsFromShoppingCartTable;
import static steps.CartPageSteps.getProductsFromShoppingCartTable;
import static steps.CartPageSteps.goToCheckout;
import static steps.CartPageSteps.removeProductFromShoppingCartTable;
import static steps.CartPageSteps.updateCart;

public class TestCartPage extends BaseTest {

    protected static CartPage cartPage;

    @BeforeAll
    public static void setUp() {
        cartPage = new CartPage();
    }

    @AfterEach
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    @Tag("EndToEnd")
    public void proceedToCheckout() {
        // Given:
        openPage();
        addToCart();
        goToCart();

        // When:
        goToCheckout();

        // Then:
        BaseSteps.validateURL("https://automationteststore.com/index.php?rt=account/login");
    }

    @Test
    @Tag("EndToEnd")
    public void shoppingCartTableTest() {
        // Given:
        openPage();
        addProductToCartById("50");
        addProductToCartById("68");
        addProductToCartById("65");
        goToCart();

        // When:
        var checkoutProducts = getCheckoutProductsFromShoppingCartTable();
        ProductModel product1 = ProductModel.builder()
                .name("Skinsheen Bronzer Stick")
                .model("558003")
                .priceCurrency(Currency.USD)
                .price(new BigDecimal("29.50"))
                .imageUrl("https://automationteststore.com/image/thumbnails/18/6f/demo_product01_jpg-100089-75x75.jpg")
                .build();

        // Then:
        Assert.assertEquals(3, checkoutProducts.size());
        checkIfProductAppearsOnce(product1, checkoutProducts);
    }

    @Test
    @Tag("EndToEnd")
    public void shoppingCartTableQuantityAndTotalPriceTest() {
        // Given:
        openPage();
        addProductToCartById("50");
        addProductToCartById("68");
        addProductToCartById("65");
        goToCart();

        // When:
        var products = getProductsFromShoppingCartTable();
        changeQuantityOfProduct(products.get(0), 2);
        changeQuantityOfProduct(products.get(1), 3);
        changeQuantityOfProduct(products.get(2), 4);
        updateCart();

        // Then:
        var checkoutProducts = getCheckoutProductsFromShoppingCartTable();
        checkIfTotalPricesAreCorrectPerProduct(products, checkoutProducts);
    }

    @Test
    @Tag("EndToEnd")
    public void shoppingCartTableRemoveProductTest() {
        // Given:
        openPage();
        addProductToCartById("50");
        addProductToCartById("68");
        addProductToCartById("65");
        goToCart();

        // When:
        var checkoutProductsBeforeRemove = getCheckoutProductsFromShoppingCartTable();
        removeProductFromShoppingCartTable(checkoutProductsBeforeRemove.get(0));
        var expectedProductsAfterRemove = new ArrayList<>(checkoutProductsBeforeRemove);
        expectedProductsAfterRemove.remove(0);

        // Then:
        var checkoutProductsAfterRemove = getCheckoutProductsFromShoppingCartTable();
        Assert.assertEquals(2, checkoutProductsAfterRemove.size());
        Assert.assertEquals(expectedProductsAfterRemove, checkoutProductsAfterRemove);
    }

    @Test
    @Tag("EndToEnd")
    public void shoppingCartTableEmptyCartTest() {
        // Given:
        openPage();
        addProductToCartById("50");
        goToCart();

        // When:
        var checkoutProductsBeforeRemove = getCheckoutProductsFromShoppingCartTable();
        removeProductFromShoppingCartTable(checkoutProductsBeforeRemove.get(0));

        // Then:
        checkIfCartIsEmpty();
    }
}