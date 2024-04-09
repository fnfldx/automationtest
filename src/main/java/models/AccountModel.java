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
                .loginName(CustomerModelUtils.generateLoginName())
                .password(CustomerModelUtils.generatePassword())
                .build();
    }

    public static AccountModel withRandomCustomerModel() {
        return AccountModel.builder()
                .customerModel(CustomerModelUtils.generateCustomerWithRandomData())
                .loginName(CustomerModelUtils.generateLoginName())
                .password(CustomerModelUtils.generatePassword())
                .build();
    }
}
