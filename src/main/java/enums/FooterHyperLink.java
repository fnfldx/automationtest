package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum FooterHyperLink {
    ABOUT_US("About us"),
    PRIVACY_POLICY("Privacy policy"),
    RETURN_POLICY("Return policy"),
    SHIPPING("Shipping"),
    CONTACT_US("Contact us"),
    SITE_MAP("Site map"),
    LOGIN("Login");

    private final String text;
}