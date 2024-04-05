package pages.mainpage;

import enums.MainPageSectionId;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;

@Getter
@Setter
public class MainPage extends BasePage {
    private MainPageSection mainPageSection;
    private MainPageProduct mainPageProduct;

    public MainPage(WebDriver driver) {
        super();
        this.mainPageSection = new MainPageSection(driver);
        this.mainPageProduct = new MainPageProduct(driver);
    }

    public void getIdentifiersForAllSections() {
        for (MainPageSectionId sectionId : MainPageSectionId.values()) {
            List<Integer> productIds = mainPageSection.getProductIdsFromSection(sectionId);
        }
    }

    public void countProductsInAllSections() {
        for (MainPageSectionId sectionId : MainPageSectionId.values()) {
            int count = mainPageSection.countProductsInSection(sectionId);

        }
    }

    public void addProductToCartFromMainPage(int productId) {
        mainPageProduct.setProductId(productId);
        mainPageProduct.clickAddToCartButton();
    }
}
