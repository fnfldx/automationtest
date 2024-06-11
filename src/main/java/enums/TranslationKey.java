package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static engine.property.manager.PropertyManager.tr;

@Getter
@RequiredArgsConstructor
public enum TranslationKey {
    //Welcome Message
    WELCOME_MESSAGE("welcomeMessage"),
    IMAGE_HEADER("imageHeader"),
    NAME_HEADER("nameHeader"),
    MODEL_HEADER("modelHeader"),
    UNIT_PRICE_HEADER("unitePriceHeader"),
    QUANTITY_HEADER("quantityHeader"),
    TOTAL_HEADER("totalHeader"),
    REMOVE_HEADER("removeHeader"),
    //Category Menu Button Text
    HOME_BUTTON("homeButton"),
    APPAREL_BUTTON("apparelButton"),
    MAKEUP_BUTTON("makeupButton"),
    SKINCARE_BUTTON("skincareButton"),
    FRAGRANCE_BUTTON("fragranceButton"),
    MEN_BUTTON("menButton"),
    HAIR_CARE_BUTTON("hairCareButton"),
    BOOKS_BUTTON("booksButton"),
    //Footer Hyper Link Text
    ABOUT_US_LINK("aboutUsLink"),
    PRIVACY_POLICY_LINK("privacyPolicyLink"),
    RETURN_POLICY_LINK("returnPolicyLink"),
    SHIPPING_LINK("shippingLink"),
    CONTACT_US_LINK("contactUsLink"),
    SITE_MAP_LINK("siteMapLink"),
    LOGIN_LINK("loginLink"),
    //Customer Default Country
    DEFAULT_COUNTRY("defaultCountry"),
    DEFAULT_STATE("defaultState"),
    //Empty Cart Message
    EMPTY_CART_MESSAGE("emptyCartMessage"),
    //Products Names
    SKINSHEEN_BRONZER_STICK("skinsheenBronzerStick"),
    //Checkout
    SUCCESS_CHECKOUT_MESSAGE("successCheckoutMessage");

    private final String key;

    public String getTranslation() {
        return tr.getString(key);
    }
}