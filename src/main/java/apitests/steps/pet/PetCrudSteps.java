package apitests.steps.pet;

import apitests.model.Pet;
import apitests.steps.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PetCrudSteps extends BaseSteps {

    @When("Finds Pets by status {string}")
    public void finds_pets_by_status(String status) {
        response.setResponse(petClient.getPetsByStatus(status));
    }

    @Then("The response with status code {int} is returned")
    public void the_response_with_status_code_is_returned(Integer statusCode) {
        response.getResponse().then().log().all().statusCode(statusCode);
    }

    @And("Check if status {string} is returned")
    public void check_if_status_is_returned(String expectedStatus) {
        final List<Pet> pets = Arrays.asList(response.getResponse().getBody().as(Pet[].class));

        final List<String> statuses = pets.stream().map(Pet::getStatus).toList();

        assertThat(statuses).containsOnly(expectedStatus);
    }
}
