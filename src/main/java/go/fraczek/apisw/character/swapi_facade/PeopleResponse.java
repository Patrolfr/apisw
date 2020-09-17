package go.fraczek.apisw.character.swapi_facade;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class PeopleResponse {

    private String name;
    private String height;
    private String mass;
    @JsonAlias(value = "hair_color")
    private String hairColor;
    @JsonAlias(value = "skin_color")
    private String skinColor;
    @JsonAlias(value = "eye_color")
    private String eyeColor;
    @JsonAlias(value = "birth_year")
    private String birthYear;
    private String homeworld;
    private List<String> starships;
}
