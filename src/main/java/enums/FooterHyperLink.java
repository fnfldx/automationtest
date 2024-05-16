package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static enums.TranslationKey.ABOUT_US_LINK;
import static enums.TranslationKey.CONTACT_US_LINK;
import static enums.TranslationKey.LOGIN_LINK;
import static enums.TranslationKey.PRIVACY_POLICY_LINK;
import static enums.TranslationKey.RETURN_POLICY_LINK;
import static enums.TranslationKey.SHIPPING_LINK;
import static enums.TranslationKey.SITE_MAP_LINK;

@Getter
@RequiredArgsConstructor
@ToString
public enum FooterHyperLink {
    ABOUT_US(ABOUT_US_LINK.getTranslation()),
    PRIVACY_POLICY(PRIVACY_POLICY_LINK.getTranslation()),
    RETURN_POLICY(RETURN_POLICY_LINK.getTranslation()),
    SHIPPING(SHIPPING_LINK.getTranslation()),
    CONTACT_US(CONTACT_US_LINK.getTranslation()),
    SITE_MAP(SITE_MAP_LINK.getTranslation()),
    LOGIN(LOGIN_LINK.getTranslation());

    private final String text;
}
