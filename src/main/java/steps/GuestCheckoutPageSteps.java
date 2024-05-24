package steps;

import models.CustomerModelUtils;
import pages.GuestCheckoutPage;

public class GuestCheckoutPageSteps {
    protected static GuestCheckoutPage guestCheckoutPage;
    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();

        guestCheckoutPage.fillInput(guestCheckoutPage.firstNameInputLocator, customer.firstName);
        guestCheckoutPage.fillInput(guestCheckoutPage.lastNameInputLocator, customer.lastName);
        guestCheckoutPage.fillInput(guestCheckoutPage.emailInputLocator, customer.email);
        guestCheckoutPage.fillInput(guestCheckoutPage.telephoneInputLocator, customer.phone);
        guestCheckoutPage.fillInput(guestCheckoutPage.faxInputLocator, customer.fax);
        guestCheckoutPage.fillInput(guestCheckoutPage.companyInputLocator, customer.company);
        guestCheckoutPage.fillInput(guestCheckoutPage.address1InputLocator, customer.address1);
        guestCheckoutPage.fillInput(guestCheckoutPage.address2InputLocator, customer.address2);
        guestCheckoutPage.fillInput(guestCheckoutPage.cityInputLocator, customer.city);
        guestCheckoutPage.fillInput(guestCheckoutPage.postCodeInputLocator, customer.zipCode);
        guestCheckoutPage.selectOptionRegionOrCountry(guestCheckoutPage.regionInputLocator, customer.state);
        guestCheckoutPage.selectOptionRegionOrCountry(guestCheckoutPage.countryInputLocator, customer.country);
    }

    public static void fillGuestCheckoutWithShippingAddressForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        var customerShippingAddress = CustomerModelUtils.generateCustomerWithRandomData();

        guestCheckoutPage.fillInput(guestCheckoutPage.firstNameInputLocator, customer.firstName);
        guestCheckoutPage.fillInput(guestCheckoutPage.lastNameInputLocator, customer.lastName);
        guestCheckoutPage.fillInput(guestCheckoutPage.emailInputLocator, customer.email);
        guestCheckoutPage.fillInput(guestCheckoutPage.telephoneInputLocator, customer.phone);
        guestCheckoutPage.fillInput(guestCheckoutPage.faxInputLocator, customer.fax);
        guestCheckoutPage.fillInput(guestCheckoutPage.companyInputLocator, customer.company);
        guestCheckoutPage.fillInput(guestCheckoutPage.address1InputLocator, customer.address1);
        guestCheckoutPage.fillInput(guestCheckoutPage.address2InputLocator, customer.address2);
        guestCheckoutPage.fillInput(guestCheckoutPage.cityInputLocator, customer.city);
        guestCheckoutPage.fillInput(guestCheckoutPage.postCodeInputLocator, customer.zipCode);
        guestCheckoutPage.selectOptionRegionOrCountry(guestCheckoutPage.regionInputLocator, customer.state);
        guestCheckoutPage.selectOptionRegionOrCountry(guestCheckoutPage.countryInputLocator, customer.country);

        //Shipping Address
        guestCheckoutPage.selectShippingAddressCheckbox();

        guestCheckoutPage.fillInput(guestCheckoutPage.firstNameShippingInputLocator, customerShippingAddress.firstName);
        guestCheckoutPage.fillInput(guestCheckoutPage.lastNameShippingInputLocator, customerShippingAddress.lastName);
        guestCheckoutPage.fillInput(guestCheckoutPage.companyShippingInputLocator, customerShippingAddress.company);
        guestCheckoutPage.fillInput(guestCheckoutPage.address1ShippingInputLocator, customerShippingAddress.address1);
        guestCheckoutPage.fillInput(guestCheckoutPage.address2ShippingInputLocator, customerShippingAddress.address2);
        guestCheckoutPage.fillInput(guestCheckoutPage.cityShippingInputLocator, customerShippingAddress.city);
        guestCheckoutPage.fillInput(guestCheckoutPage.postCodeShippingInputLocator, customerShippingAddress.zipCode);
        guestCheckoutPage.selectOptionRegionOrCountry(guestCheckoutPage.regionShippingInputLocator, customerShippingAddress.state);
        guestCheckoutPage.selectOptionRegionOrCountry(guestCheckoutPage.countryShippingInputLocator, customerShippingAddress.country);
    }

    public static void submitGuestCheckoutForm() {
        guestCheckoutPage = new GuestCheckoutPage();
        guestCheckoutPage.clickOnContinueButton();
    }
}