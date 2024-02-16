package models;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

public class CustomerModel {

    Faker fakerEN = Faker.instance(new Locale("en-gb"));
    @Getter
    @Setter
    String firstName = fakerEN.name().firstName();
    String lastName = fakerEN.name().lastName();
    String email = fakerEN.internet().safeEmailAddress();
    String address = fakerEN.address().streetAddress();
    String city = fakerEN.address().city();
    String state = fakerEN.address().stateAbbr();
    String zipCode = fakerEN.address().zipCode();
    private final String countryDefault = "United Kingdom";
    String login = fakerEN.name().username();
    String password = fakerEN.internet().password(4, 20);
}
