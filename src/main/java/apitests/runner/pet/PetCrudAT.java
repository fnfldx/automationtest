package apitests.runner.pet;

import apitests.runner.BaseAT;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/cucumber/features/pet/pet_crud.feature")
public class PetCrudAT extends BaseAT {
}
