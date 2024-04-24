package apitests.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Getter
@Builder
@FieldNameConstants
public class Pet {

    public final Long id;
    public final Category category;
    public final String name;
    public final List<String> photoUrls;
    public final List<Tag> tags;
    public final String status;

    @JsonCreator
    public Pet(@JsonProperty("id") Long id,
               @JsonProperty("category") Category category,
               @JsonProperty("name") String name,
               @JsonProperty("photoUrls") List<String> photoUrls,
               @JsonProperty("tags") List<Tag> tags,
               @JsonProperty("status") String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}
