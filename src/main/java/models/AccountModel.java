package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class AccountModel {
    public CustomerModel customerModel;
    public Boolean isSubscribedToNewsletter;
    public String loginName;
    public String password;

    public AccountModel(CustomerModel customerModel, Boolean isSubscribedToNewsletter) {
        this.customerModel = customerModel;
        this.isSubscribedToNewsletter = isSubscribedToNewsletter;
        this.loginName = customerModel.getLogin();
        this.password = customerModel.getPassword();
    }

    public AccountModel() {
        var customerModel = CustomerModelUtils.generateCustomerWithRandomData();
        this.customerModel = customerModel;
        this.loginName = customerModel.getLogin();
        this.password = customerModel.getPassword();

        Random random = new Random();
        this.isSubscribedToNewsletter = random.nextBoolean();
    }
}
