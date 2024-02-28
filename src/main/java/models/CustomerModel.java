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
    public final String address;
    public final String city;
    public final String state;
    public final String zipCode;
    public final String login;
    public final String password;

    @Builder.Default
    public final String countryDefault = "United Kingdom"; // You can set the default country here
}