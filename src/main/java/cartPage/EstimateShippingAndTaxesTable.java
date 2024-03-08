package cartPage;

import org.openqa.selenium.By;

public class EstimateShippingAndTaxesTable {
    public final String estimateShippingAndTaxesTable = "//*[@id='cart']/div/div[2]/div[2]";

    public By countryDropdownLocator = By.xpath(estimateShippingAndTaxesTable + "//*[@id='estimate_country']");
    public By stateDropdownLocator = By.xpath(estimateShippingAndTaxesTable + "//*[@id='estimate_country_zones']");
    public By zipPostCodeLocator = By.xpath(estimateShippingAndTaxesTable + "//input[@id='estimate_postcode']");
    public By estimateButtonLocator = By.xpath(estimateShippingAndTaxesTable + "//button[@title='Estimate']");
    public By shipmentsDropdownLocator = By.xpath(estimateShippingAndTaxesTable + "//*[@id='shippings']");
}
