package go.fraczek.apisw.character.swapi_facade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class PeoplePageResponse {

    private int count;
    private List<PeopleResponse> results;
}
