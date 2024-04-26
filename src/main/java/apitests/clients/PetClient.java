package apitests.clients;

import apitests.model.Pet;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetClient extends BaseClient {

    private static final String PET_URL = BASE_URL + "/pet/";

    public Response getPetsByStatus(final String status) {
        return given()
                .when()
                .queryParams("status", status)
                .get(PET_URL + "findByStatus");
    }

    public Response postPet(final Pet pet) {
        return given()
                .contentType("application/json")
                .body(pet)
                .when()
                .post(PET_URL);
    }
}
