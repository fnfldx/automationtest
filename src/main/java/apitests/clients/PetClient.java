package apitests.clients;

import apitests.model.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class PetClient extends BaseClient {

    private static final String PET_URL = BASE_URL + "/pet/";

    public Response getPetsByStatus(final String status) {
        return given()
                .when()
                .queryParams(Pet.Fields.status, status)
                .get(PET_URL + "findByStatus");
    }

    public Response getPetById(final long petId) {
        return given()
                .when()
                .get(PET_URL + petId);
    }

    public Response postPet(final Pet pet) {
        return given()
                .contentType(JSON)
                .body(pet)
                .when()
                .post(PET_URL);
    }

    public Response putPet(final Pet pet) {
        return given()
                .contentType(JSON)
                .body(pet)
                .when()
                .put(PET_URL);
    }

    public Response deletePet(final long petId) {
        return given()
                .when()
                .delete(PET_URL + petId);
    }
}