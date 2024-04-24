package apitests.model;

import static java.util.Arrays.asList;

public class PetUtils {
    public static Pet generatePetWithTestData() {
        return Pet.builder()
                .id(123L)
                .category(Category.builder()
                        .id(231L)
                        .name("Catis").build())
                .name("rose")
                .photoUrls(asList("Url1", "Url2"))
                .tags(asList(Tag.builder()
                        .id(321L)
                        .name("Tagis").build()))
                .status("available")
                .build();
    }
}
