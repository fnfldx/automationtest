package models;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.Locale;

@Getter
@Setter
@Builder
@Value

public class CustomerModel {

    Faker fakerEN = Faker.instance(new Locale("en-gb"));

    public String firstName = fakerEN.name().firstName();
    public String lastName = fakerEN.name().lastName();
    public String email = fakerEN.internet().safeEmailAddress();
    public String address = fakerEN.address().streetAddress();
    public String city = fakerEN.address().city();
    public String state = fakerEN.address().stateAbbr();
    public String zipCode = fakerEN.address().zipCode();
    public final String countryDefault = "United Kingdom";
    public String login = fakerEN.name().username();
    public String password = fakerEN.internet().password(4, 20);
}
