package models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class CustomerModelUtils {
    private static Faker fakerEN = new Faker(new Locale("en-GB"));

    public static CustomerModel generateCustomerWithRandomData() {
        // generate a new data pack for each field
        return CustomerModel.builder()
                .firstName(fakerEN.name().firstName())
                .lastName(fakerEN.name().lastName())
                .email(fakerEN.internet().emailAddress())
                .phone(fakerEN.phoneNumber().cellPhone())
                .fax(fakerEN.phoneNumber().cellPhone())
                .company(fakerEN.company().name())
                .address1(fakerEN.address().streetAddress())
                .address2(fakerEN.address().streetAddress())
                .city(fakerEN.address().cityName())
                .zipCode(fakerEN.address().zipCode())
                .login(fakerEN.name().username())
                .password(fakerEN.internet().password(4, 20))
                .build();
    }
}
