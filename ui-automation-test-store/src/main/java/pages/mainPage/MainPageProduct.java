package pages.mainPage;

import lombok.Getter;
import models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import pages.BasePage;

import java.math.BigDecimal;

import static enums.Currency.getPriceAsBigDecimal;

@Getter
public class MainPageProduct {
    protected BasePage basePage;
    private final String productXpath;

    public MainPageProduct(int productIndex, String sectionXpath) {
        this.basePage = new BasePage();
        this.productXpath = sectionXpath + String.format("//div[@class='thumbnails list-inline']/div[%s]", productIndex);
    }

    public ProductModel getProductsDetails() {
        return ProductModel.builder()
                .name(getProductName())
                .price(getPrice())
                .build();
    }

    public void clickAddToCartButton() {
        var outOfStockElement = By.xpath(productXpath + "//span[@class='nostock']");
        var addToCartButton = By.xpath(productXpath + "//a[@class='productcart']");

        if (basePage.isElementDisplayed(outOfStockElement)) {
            throw new IllegalStateException("Product is out of stock and cannot be added to the cart.");
        } else if (basePage.isElementDisplayed(addToCartButton)) {
            basePage.clickOnElement(addToCartButton);
        } else {
            throw new NoSuchElementException("Add to cart button is not present for the product.");
        }
    }

    private String getProductName() {
        return basePage.getTextFromElement(By.xpath(productXpath + "//a[@class='prdocutname']"));
    }

    private BigDecimal getPrice() {
        var priceElement = By.xpath(productXpath + "//div[@class='oneprice' or @class='pricenew']");
        String priceText = basePage.getTextFromElement(priceElement);
        return getPriceAsBigDecimal(priceText);
    }
}