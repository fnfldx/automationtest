package temporary.tests;

import enums.Currency;
import models.ProductModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.cartPage.CartPage;
import steps.MainPageSteps;

import java.math.BigDecimal;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.CartPageSteps.checkIfProductAppearsOnce;
import static steps.CartPageSteps.getProductsFromShoppingTable;
import static steps.CartPageSteps.goToCheckout;
import static steps.MainPageSteps.addProductToCartById;
import static steps.MainPageSteps.addToCart;
import static steps.MainPageSteps.goToCart;
import static steps.MainPageSteps.openPage;

public class TestCartPage extends BaseTest {

    protected static CartPage cartPage;
    protected static MainPageSteps mainPageSteps;

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
        MainPageSteps.validateURL("https://automationteststore.com/index.php?rt=account/login");
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
        var products = getProductsFromShoppingTable();
        ProductModel product1 = ProductModel.builder()
                .name("Skinsheen Bronzer Stick")
                .model("558003")
                .priceCurrency(Currency.USD)
                .price(new BigDecimal("29.50"))
                .isOnSale(null)
                .priceBeforeSale(null)
                .isOutOfStock(null)
                .imageUrl("https://automationteststore.com/image/thumbnails/18/6f/demo_product01_jpg-100089-75x75.jpg")
                .build();

        // Then:
        Assert.assertEquals(3, products.size());
        checkIfProductAppearsOnce(product1, products);
    }
}