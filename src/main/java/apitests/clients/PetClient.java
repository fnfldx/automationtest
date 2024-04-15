package apitests.clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetClient extends BaseClient {

    public Response getPetsByStatus(final String status) {
        RestAssured.baseURI = BASE_URL;
        return given().when().queryParams("status", status).get("/v2/pet/findByStatus?status=sold");
    }
}
