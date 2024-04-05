package pages.mainpage;

import enums.MainPageSectionId;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

@Getter
@Setter
public class MainPageSection extends BasePage {
    private MainPageProduct mainPageProduct;

    public MainPageSection(WebDriver driver) {
        super();
        this.mainPageProduct = new MainPageProduct(driver);
    }

    public List<MainPageProduct> getAllProductsFromSection(MainPageSectionId sectionId) {
        List<WebElement> productElements = getWebDriverInstance().findElements(By.xpath("//div[@id='" + sectionId + "']//div[contains(@class, 'product')]"));
        List<MainPageProduct> products = new ArrayList<>();
        for (WebElement productElement : productElements) {
            MainPageProduct product = new MainPageProduct(getWebDriverInstance());
            int productId = Integer.parseInt(productElement.findElement(By.xpath(".//a[contains(@class, 'productcart')]")).getAttribute("data-id"));
            product.setProductId(productId);
            products.add(product);
        }
        return products;
    }


    public List<Integer> getProductIdsFromSection(MainPageSectionId sectionId) {
        return getWebDriverInstance().findElements(By.xpath("//div[@id='" + sectionId + "']//a[contains(@class, 'productcart')]"))
                .stream()
                .map(element -> element.getAttribute("data-id"))
                .filter(dataId -> dataId != null && !dataId.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public int countProductsInSection(MainPageSectionId sectionId) {
        return getWebDriverInstance().findElements(By.xpath("//div[@id='" + sectionId + "']//div[contains(@class, 'product')]")).size();
    }
}
