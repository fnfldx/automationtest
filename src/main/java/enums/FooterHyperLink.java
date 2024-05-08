package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import static engine.property.manager.PropertyManager.tr;

@Getter
@RequiredArgsConstructor
@ToString
public enum FooterHyperLink {
    ABOUT_US(tr.getString("aboutUsLink")),
    PRIVACY_POLICY(tr.getString("privacyPolicyLink")),
    RETURN_POLICY(tr.getString("returnPolicyLink")),
    SHIPPING(tr.getString("shippingLink")),
    CONTACT_US(tr.getString("contactUsLink")),
    SITE_MAP(tr.getString("siteMapLink")),
    LOGIN(tr.getString("loginLink"));

    private final String text;
}