package pages.mainpage;

import enums.MainPageSectionId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to a specific section using the section ID from the enum
    public void navigateToSection(MainPageSectionId sectionIdEnum) {
        By sectionLocator = By.id(sectionIdEnum.getId());
        driver.findElement(sectionLocator).click();
    }

    // Other methods specific to MainPage interactions...
}