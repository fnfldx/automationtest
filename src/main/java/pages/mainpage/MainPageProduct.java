package pages.mainpage;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Setter
@Getter
public class MainPageProduct extends BasePage {
    private int productId;

    public MainPageProduct(WebDriver driver) {
        super();
    }

    public String getProductName() {
        By productNameElement = By.xpath("//a[@class='productname' and @data-id='" + productId + "']");
        return getTextFromElement(productNameElement);
    }

    public double getPrice() {
        By priceElement = By.xpath("//div[@class='oneprice' and @data-id='" + productId + "']");
        String priceText = getTextFromElement(priceElement);
        return Double.parseDouble(priceText.replace(" zł", "").replace(",", "."));
    }

    public void clickAddToCartButton() {
        By addToCartButton = By.xpath("//a[@class='productcart' and @data-id='" + productId + "']");
        clickOnElement(addToCartButton);
    }
}
