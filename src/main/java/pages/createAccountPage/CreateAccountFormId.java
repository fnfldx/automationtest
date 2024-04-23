package pages.createAccountPage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum CreateAccountFormId {
    FIRST_NAME("AccountFrm_firstname"),
    LAST_NAME("AccountFrm_lastname"),
    EMAIL("AccountFrm_email"),
    TELEPHONE("AccountFrm_telephone"),
    FAX("AccountFrm_fax"),
    COMPANY("AccountFrm_company"),
    ADDRESS1("AccountFrm_address_1"),
    ADDRESS2("AccountFrm_address_2"),
    CITY("AccountFrm_city"),
    REGION_STATE("AccountFrm_zone_id"),
    ZIPCODE("AccountFrm_postcode"),
    COUNTRY("AccountFrm_country_id"),
    LOGIN_NAME("AccountFrm_loginname"),
    PASSWORD("AccountFrm_password"),
    CONFIRM_PASSWORD("AccountFrm_confirm"),
    SUBSCRIBE_YES("AccountFrm_newsletter1"),
    SUBSCRIBE_NO("AccountFrm_newsletter0"),
    PRIVACY_POLICY("AccountFrm_agree");

    public final String id;
}