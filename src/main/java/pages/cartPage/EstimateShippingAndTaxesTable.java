package pages.cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class EstimateShippingAndTaxesTable {

    protected WebDriver driver;
    public String zipPostCode = "";
    public By countryDropdownLocator = By.id("estimate_country");
    public By stateDropdownLocator = By.id("estimate_country_zones");
    public By zipPostCodeLocator = By.id("estimate_postcode");
    public By estimateButtonLocator = By.xpath("//button[@title='Estimate']");
    public By shipmentsDropdownLocator = By.id("shippings");

    BasePage basePage = new BasePage(driver);

    void enterZipPostCode() {
        basePage.enterTextToElement(zipPostCodeLocator, zipPostCode);
    }

    void clickOnEstimateButton() {
        basePage.clickOnElement(estimateButtonLocator);
    }

}


