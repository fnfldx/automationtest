package apitests.steps;

import apitests.clients.PetClient;
import apitests.model.ResponseDetails;

public class BaseSteps {

    protected ResponseDetails response;

    protected PetClient petClient;

    public BaseSteps() {
        this.petClient = new PetClient();
        this.response = new ResponseDetails();
    }
}
