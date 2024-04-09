package models;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class CustomerModel {
    public final String firstName;
    public final String lastName;
    public final String email;
    public final String phone;
    public final String fax;
    public final String company;
    public final String address1;
    public final String address2;
    public final String city;
    public final String zipCode;

    @Builder.Default
    public final String countryDefault = "United Kingdom"; // You can set the default country here
    public final String stateDefault = "Aberdeen";
}