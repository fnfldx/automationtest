package cartPage;

import org.openqa.selenium.By;

public class EstimateShippingAndTaxesTable {
    public final String EstimateShippingAndTaxesTable = "//*[@id='cart']/div/div[2]/div[2]";

    public By countryDropdownLocator = By.xpath(EstimateShippingAndTaxesTable + "//*[@id='estimate_country']");
    public By stateDropdownLocator = By.xpath(EstimateShippingAndTaxesTable + "//*[@id='estimate_country_zones']");
    public By zipPostCodeLocator = By.xpath(EstimateShippingAndTaxesTable + "//input[@id='estimate_postcode']");
    public By estimateButtonLocator = By.xpath(EstimateShippingAndTaxesTable + "//button[@title='Estimate']");
    public By shipmentsDropdownLocator = By.xpath(EstimateShippingAndTaxesTable + "//*[@id='shippings']");

}
