package steps;


import pages.cartPage.CartPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartPageSteps {

    protected static CartPage cartPage;

    public static void updateCart() {
        cartPage = new CartPage();
        cartPage.clickOnUpdateButton();
    }

    public static void goToCheckout() {
        cartPage = new CartPage();
        cartPage.clickOnFinalCheckoutButton();
    }

    public static void validateTotalPrice() {
        cartPage = new CartPage();
        var subTotalPrice = cartPage.totalsTable.getSubTotalPrize();
        var shippingPrice = cartPage.totalsTable.getFlatShippingRatePrize();
        var totalPrice = cartPage.totalsTable.getTotalPrize();

        assertThat(totalPrice).isEqualTo(subTotalPrice.add(shippingPrice));
    }
}