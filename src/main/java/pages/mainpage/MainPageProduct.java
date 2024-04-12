package pages.mainpage;

import lombok.Getter;
import org.openqa.selenium.By;
import pages.BasePage;

@Getter
public class MainPageProduct {
    protected BasePage basePage;
    private final String productXpath;

    public MainPageProduct(int productId, String sectionXpath) {
        this.basePage = new BasePage();
        this.productXpath = sectionXpath + "//*[@data-id='" + productId + "']/ancestor::" + sectionXpath;
    }

    public String getProductName() {
        By productNameElement = By.xpath(productXpath + "//a[@class='productname']");
        return basePage.getTextFromElement(productNameElement);
    }

    public double getPrice() {
        By priceElement = By.xpath(productXpath + "//div[@class='oneprice']");
        String priceText = basePage.getTextFromElement(priceElement);
        return Double.parseDouble(priceText.replace(" zł", "").replace(",", "."));
    }

    public void clickAddToCartButton() {
        By addToCartButton = By.xpath(productXpath + "//a[@class='productcart']");
        basePage.clickOnElement(addToCartButton);
    }
}