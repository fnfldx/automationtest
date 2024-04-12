package pages.mainpage;

import enums.MainPageSectionId;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

@Getter
@Setter
public class MainPageSection {
    protected BasePage basePage;
    private String sectionXpath;

    public MainPageSection(MainPageSectionId sectionId)  {
        this.basePage = new BasePage();
        this.sectionXpath = "//section[@id='" + sectionId + "']";
    }

    public List<Integer> getProductIdsFromSection() {
        return getWebDriverInstance().findElements(By.xpath(this.sectionXpath + "/div/div"))
                .stream()
                .map(element -> element.getAttribute("data-id"))
                .filter(dataId -> dataId != null && !dataId.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int countProductsInSection() {
        return getProductIdsFromSection().size();
    }

    public MainPageProduct getProduct(int productId) {
        MainPageProduct mainPageProduct = new MainPageProduct(productId, this.sectionXpath);
        String productName = mainPageProduct.getProductName();
        return mainPageProduct;
    }
}
