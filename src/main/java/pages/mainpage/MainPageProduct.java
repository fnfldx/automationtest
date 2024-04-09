package pages.mainpage;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;


@Getter
public class MainPageProduct {
    private String productXpath;
    protected BasePage basePage;

    public MainPageProduct(int productId, String sectionXpath) {
        this.basePage = new BasePage();
        this.productXpath = sectionXpath + " and @data-id='" + productId + "']";
    }

    public String getProductName() {
        By productNameElement = By.xpath(productXpath + "//a[@class='productname");
        return basePage.getTextFromElement(productNameElement);
    }

    public double getPrice() {
        By priceElement = By.xpath("//div[@class='oneprice' and @data-id='" + productId + "']");
        String priceText = basePage.getTextFromElement(priceElement);
        return Double.parseDouble(priceText.replace(" zł", "").replace(",", "."));
    }

    public void clickAddToCartButton() {
        By addToCartButton = By.xpath("//a[@class='productcart' and @data-id='" + productId + "']");
        basePage.clickOnElement(addToCartButton);
    }
}
