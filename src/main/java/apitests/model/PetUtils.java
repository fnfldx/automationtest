package apitests.model;

import java.util.Random;

import static apitests.model.Status.AVAILABLE;
import static java.lang.Math.abs;
import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;

public class PetUtils {
    private static final Long PET_ID = abs(new Random().nextLong());
    private static final String PET_NAME = randomUUID().toString();
    private static final long CATEGORY_ID = abs(new Random().nextLong());
    private static final String CATEGORY_NAME = randomUUID().toString();
    private static final Long TAG_ID = abs(new Random().nextLong());
    private static final String TAG_NAME = randomUUID().toString();
    private static final String PHOTO_URL_1 = "https://" + randomUUID() + ".com";
    private static final String PHOTO_URL_2 = "http://" + randomUUID() + ".pl";
    private static final String PET_STATUS = AVAILABLE.toString().toLowerCase();

    public static Pet generatePetWithRandomTesData() {
        return Pet.builder()
                .id(PET_ID)
                .category(Category.builder()
                        .id(CATEGORY_ID)
                        .name(CATEGORY_NAME).build())
                .name(PET_NAME)
                .photoUrls(asList(PHOTO_URL_1, PHOTO_URL_2))
                .tags(asList(Tag.builder()
                        .id(TAG_ID)
                        .name(TAG_NAME).build()))
                .status(PET_STATUS)
                .build();
    }
}
