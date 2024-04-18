package pages.mainpage;

import lombok.Getter;
import models.ProductModel;
import org.openqa.selenium.By;
import pages.BasePage;

import java.math.BigDecimal;

@Getter
public class MainPageProduct {
    protected BasePage basePage;
    private final String productXpath;

    public MainPageProduct(int productIndex, String sectionXpath) {
        this.basePage = new BasePage();
        this.productXpath = sectionXpath + String.format("//div[@class=\"thumbnails list-inline\"]/div[%s]", productIndex);
        System.out.println(productXpath);
    }

    public ProductModel getProductsDetails() {
        return ProductModel.builder()
                .name(getProductName())
                .price(getPrice())
                .build();
    }

    public void clickAddToCartButton() {
        By addToCartButton = By.xpath(productXpath + "//a[@class='productcart']");
        basePage.clickOnElement(addToCartButton);
    }

    private String getProductName() {
        By productNameElement = By.xpath(productXpath + "//a[@class='prdocutname']"); //class name is incorrect on page
        return basePage.getTextFromElement(productNameElement);
    }

    private BigDecimal getPrice() {
        By priceElement = By.xpath(productXpath + "//div[@class='oneprice']");
        String priceText = basePage.getTextFromElement(priceElement);
        return new BigDecimal(priceText.substring(1));
    }
}