package apitests.steps;

import apitests.clients.PetClient;
import apitests.model.ResponseDetails;

public class BaseSteps {

    protected ResponseDetails response;

    protected PetClient petClient;

    public BaseSteps(ResponseDetails response, PetClient petClient) {
        this.petClient = petClient;
        this.response = response;
    }
}
