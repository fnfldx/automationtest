package temporary.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.mainpage.MainPageProduct;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;
import static engine.drivers.WebDriverFactory.quitWebDriver;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;

public class MainPageProductTest {
    private MainPageProduct mainPageProduct;

    @BeforeClass
    public static void baseClassSetUp() {
        getPropertyManagerInstance();
    }

    @Before
    public void baseSetUp() {
        WebDriver driver = getWebDriverInstance();
        mainPageProduct = new MainPageProduct();
    }

    @Test
    public void testProductMethodsForId50() {
        int productId50 = 50;
        mainPageProduct.setProductId(productId50);

        // Test getPrice method for product ID 50
        double priceId50 = mainPageProduct.getPrice();
        Assert.assertTrue("Price should be greater than 0", priceId50 > 0);

        // Test getProductName method for product ID 50
        String nameId50 = mainPageProduct.getProductName();
        Assert.assertNotNull("Product name should not be null", nameId50);

        // Test addToCart method for product ID 50
        mainPageProduct.clickAddToCartButton();

    }

    @Test
    public void testProductMethodsForId51() {
        int productId51 = 51;
        mainPageProduct.setProductId(productId51);

        // Test getPrice method for product ID 51
        double priceId51 = mainPageProduct.getPrice();
        Assert.assertTrue("Price should be greater than 0", priceId51 > 0);

        // Test getProductName method for product ID 51
        String nameId51 = mainPageProduct.getProductName();
        Assert.assertNotNull("Product name should not be null", nameId51);

        // Test addToCart method for product ID 51
        mainPageProduct.clickAddToCartButton();


    }

    @After
    public void tearDown() {
        quitWebDriver();
    }
}
