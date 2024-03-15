package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class EstimateShippingAndTaxesTable {

    protected BasePage basePage;
    public By countryDropdownLocator = By.id("estimate_country");
    public By stateDropdownLocator = By.id("estimate_country_zones");
    public By zipPostCodeLocator = By.id("estimate_postcode");
    public By estimateButtonLocator = By.xpath("//button[@title='Estimate']");
    public By shipmentsDropdownLocator = By.id("shippings");

    void enterZipPostCode(String zipPostCode) {
        basePage.enterTextToElement(zipPostCodeLocator, zipPostCode);
    }

    void clickOnEstimateButton() {
        basePage.clickOnElement(estimateButtonLocator);
    }
}


