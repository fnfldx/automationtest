package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountModel {
    public CustomerModel customerModel;
    public String loginName;
    public String password;

    @Builder.Default
    public Boolean isSubscribedToNewsletter = false;

    public static AccountModel withCustomerModel(CustomerModel customerModel) {
        return AccountModel.builder()
                .customerModel(customerModel)
                .loginName(generateLoginName())
                .password(generatePassword())
                .build();
    }

    public static AccountModel withRandomCustomerModel() {
        return AccountModel.builder()
                .customerModel(CustomerModelUtils.generateCustomerWithRandomData())
                .loginName(generateLoginName())
                .password(generatePassword())
                .build();
    }

    private static String generateLoginName() {
        return CustomerModelUtils.fakerEN.name().lastName();
    }

    private static String generatePassword() {
        return CustomerModelUtils.fakerEN.internet().password();
    }
}
