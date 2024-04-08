package pages.createAccountPage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum CreateAccountForm {
    FirstName("AccountFrm_firstname"),
    LastName("AccountFrm_lastname"),
    Email("AccountFrm_email"),
    Telephone("AccountFrm_telephone"),
    Fax("AccountFrm_fax"),
    Company("AccountFrm_company"),
    Address1("AccountFrm_address_1"),
    Address2("AccountFrm_address_2"),
    City("AccountFrm_city"),
    RegionState("AccountFrm_zone_id"),
    ZIPCode("AccountFrm_postcode"),
    Country("AccountFrm_country_id"),
    LoginName("AccountFrm_loginname"),
    Password("AccountFrm_password"),
    ConfirmPassword("AccountFrm_confirm"),
    SubscribeYes("AccountFrm_newsletter1"),
    SubscribeNo("AccountFrm_newsletter0");

    public final String id;
}
