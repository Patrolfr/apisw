package go.fraczek.apisw.character.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CharacterDto {

    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private PlanetDto homeworld;
    private List<StarshipDto> starships;
}
