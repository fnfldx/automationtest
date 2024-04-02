package pages.mainpage;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Getter
@Setter
public class MainPageProduct extends BasePage {
    private String header;
    private double price;
    private WebDriver driver;

    public MainPageProduct(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public double getPrice(WebElement product) {
        By priceElement = By.xpath("//a[@class='oneprice'");
        String priceText = getTextFromElement(priceElement);
        price = Double.parseDouble(priceText);
        return price;
    }

    public String getProductName(WebElement product) {
        By productNameElement = By.xpath("//a[@class='prdocutname']");
        return getTextFromElement(productNameElement);
    }

    public void addToCart(String productId) {
        By addToCartButton = By.xpath("//a[@class='productcart' and @data-id='" + productId + "']");
        clickOnElement(addToCartButton);
    }
}