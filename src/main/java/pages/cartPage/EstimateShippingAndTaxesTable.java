package pages.cartPage;

import org.openqa.selenium.By;
import pages.BasePage;

public class EstimateShippingAndTaxesTable {
    public By estimateShippingAndTaxesTableLocator = By.xpath("//div[contains(@class,'pull-right estimate')]");
    public By countryDropdownLocator = By.id("estimate_country");
    public By stateDropdownLocator = By.id("estimate_country_zones");
    public By zipPostCodeInputLocator = By.id("estimate_postcode");
    public By estimateButtonLocator = By.xpath("//button[@title='Estimate']");
    public By shipmentsDropdownLocator = By.id("shippings");
    protected BasePage basePage;

    public void enterZipPostCode(String zipPostCode) {
        basePage.enterTextToElement(zipPostCodeInputLocator, zipPostCode);
    }

    public void clickOnEstimateButton() {
        basePage.clickOnElement(estimateButtonLocator);
    }

    public void selectCountryFromDropDown(String value) {
        basePage.selectionOptionFromDropdown(countryDropdownLocator, value);
    }

    public void selectStateFromDropDown(String value) {
        basePage.selectionOptionFromDropdown(stateDropdownLocator, value);
    }

    public void selectShipmentFromDropDown(String value) {
        basePage.selectionOptionFromDropdown(shipmentsDropdownLocator, value);
    }
}