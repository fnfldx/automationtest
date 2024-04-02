package pages.mainpage;

import enums.MainPageSectionId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class MainPageSection extends BasePage {

    private WebDriver driver;
    private MainPageSectionId sectionIdEnum;

    public MainPageSection(WebDriver driver) {
        super();
        this.driver = driver;
    }

    // Retrieves a list of products from a specific section using the section ID from the enum
    public List<WebElement> getProductsFromSection(MainPageSectionId sectionIdEnum) {
        String sectionId = sectionIdEnum.getId(); // Get the ID from the enum
        By sectionLocator = By.id(sectionId);
        scrollToElement(sectionLocator);
        return locateElement(sectionLocator).findElements(By.xpath(".//div[contains(@class, 'thumbnail')]"));
    }

    // Counts the number of products directly from the retrieved list
    public int countProducts() {
        return getProductsFromSection(sectionIdEnum).size();
    }

    // Gets a random product directly from the retrieved list
    public WebElement getRandomProduct(MainPageSectionId sectionIdEnum) {
        List<WebElement> products = getProductsFromSection(sectionIdEnum);
        Random rand = new Random();
        return products.get(rand.nextInt(products.size()));
    }
}
