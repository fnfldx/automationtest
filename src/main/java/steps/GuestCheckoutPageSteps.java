package steps;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.CustomerModel;
import models.CustomerModelUtils;
import pages.GuestCheckoutPage;

@NoArgsConstructor
@Getter
@Setter
public class GuestCheckoutPageSteps {
    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.firstnameInputLocator, customer.firstName);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.lastnameInputLocator, customer.lastName);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.emailInputLocator, customer.email);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.telephoneInputLocator, customer.telePhone);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.faxInputLocator, customer.fax);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.companyInputLocator, customer.company);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.address1InputLocator, customer.address);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.address2InputLocator, customer.address);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.cityInputLocator, customer.city);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.regionInputLocator, customer.state);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.postcodeInputLocator, customer.zipCode);
    }

    public static void fillGuestCheckoutForm() {
        GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage();
        var customer = CustomerModelUtils.generateCustomerWithRandomData();
        guestCheckoutPage.fillInput(guestCheckoutPage.countryIdInputLocator, customer.countryDefault);
    }


}