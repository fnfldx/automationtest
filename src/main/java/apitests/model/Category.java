package apitests.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@Builder
@FieldNameConstants
public class Category {

    public final Long id;
    public final String name;
    @JsonCreator
    public Category(@JsonProperty("id") Long id,
                    @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }
}
