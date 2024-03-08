package cartPage;

import org.openqa.selenium.By;

public class TotalsTable {

    public final String TotalsTable = "//table[@id='totals_table']";

    public By subTotalLocator = By.xpath(TotalsTable + "//tbody/tr[1]/td[2]/span");
    public By flatShippingRateLocator = By.xpath(TotalsTable + "//tbody/tr[2]/td[2]/span");
    public By totalLocator = By.xpath(TotalsTable + "//tbody/tr[3]/td[2]/span");



}
