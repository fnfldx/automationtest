package temporary.tests;

import enums.Currency;
import models.ProductModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
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
import static steps.CartPageSteps.checkIfTotalPriceIsCorrect;
import static steps.CartPageSteps.getCheckoutProductsFromShoppingCartTable;
import static steps.CartPageSteps.getProductsFromShoppingCartTable;
import static steps.CartPageSteps.goToCheckout;
import static steps.CartPageSteps.removeProductFromShoppingCartTable;
import static steps.CartPageSteps.updateCart;

public class TestCartPage extends BaseTest {

    protected static CartPage cartPage;

    @BeforeClass
    public static void setUp() {
        cartPage = new CartPage();
    }

    @After
    public void tearDown() {
        quitWebDriver();
    }

    @Test
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
        checkIfTotalPriceIsCorrect(products, checkoutProducts);
    }

    @Test
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