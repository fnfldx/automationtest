package endpoints;

import static clients.BaseClient.BASE_URL;

public class Routes {
    //Pet
    public static final String PET_URL = BASE_URL + "/pet";
    public static final String PET_ADD = PET_URL;
    public static final String PET_UPDATE = PET_URL;
    public static final String PET_DELETE = PET_URL + "/{petId}";
    public static final String PET_UPDATE_BY_FORM = PET_URL + "/{petId}";
    public static final String PET_FIND_BY_ID = PET_URL + "/{petId}";
    public static final String PET_FIND_BY_STATUS = PET_URL + "/findByStatus";
    public static final String PET_UPLOAD_IMAGE = PET_URL + "/{petId}/uploadImage";
}