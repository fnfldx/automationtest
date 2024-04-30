package apitests.steps.pet;

import apitests.clients.PetClient;
import apitests.model.Pet;
import apitests.model.ResponseDetails;
import apitests.steps.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;

import java.util.Arrays;
import java.util.List;

import static apitests.model.PetUtils.generatePetWithRandomTestData;
import static org.assertj.core.api.Assertions.assertThat;

public class PetCrudSteps extends BaseSteps {

    private static final Pet newPet = generatePetWithRandomTestData();

    public PetCrudSteps(ResponseDetails response, PetClient petClient) {
        super(response, petClient);
    }

    @When("Add a new pet to the store")
    public void add_a_new_pet_to_the_store() {
        response.setResponse(petClient.postPet(newPet));
    }

    @When("Finds Pets by status {string}")
    public void finds_pets_by_status(String status) {
        response.setResponse(petClient.getPetsByStatus(status));
    }

    @And("Check if status {string} is returned")
    public void check_if_status_is_returned(String expectedStatus) {
        final List<Pet> pets = Arrays.asList(response.getResponse().getBody().as(Pet[].class, ObjectMapperType.GSON));

        final List<String> statuses = pets.stream().map(Pet::getStatus).toList();

        assertThat(statuses).containsOnly(expectedStatus);
    }

    @And("Check the response body of created pet is correct")
    public void check_the_response_body_of_created_pet_is_correct() {
        final Pet createdPet = response.getResponse().getBody().as(Pet.class);

        assertThat(createdPet).isEqualToComparingFieldByFieldRecursively(newPet);
    }
}
