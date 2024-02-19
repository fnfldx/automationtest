package models;

import com.github.javafaker.Faker;
import lombok.*;

import java.util.Locale;

@Getter
@Setter

public class CustomerModel {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private final String countryDefault = "United Kingdom"; // You can set the default country here
    private String login;
    private String password;

    Faker fakerEN = Faker.instance(new Locale("en-gb"));

    public CustomerModel() {
        //Generate data pack
        this.generateData();
    }

    public void generateData() {
        // generate a new data pack for each field
        this.firstName = fakerEN.name().firstName();
        this.lastName = fakerEN.name().lastName();
        this.email = fakerEN.internet().safeEmailAddress();
        this.address = fakerEN.address().streetAddress();
        this.city = fakerEN.address().cityName();
        this.state = fakerEN.address().stateAbbr();
        this.zipCode = fakerEN.address().zipCode();
        this.login = fakerEN.name().username();
        this.password = fakerEN.internet().password(4, 20);
    }
}