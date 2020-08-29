package go.fraczek.apisw.character.model;

import lombok.Value;

import java.util.List;

@Value
public class CharacterDto {

    String name;
    String height;
    String mass;
    String hairColor;
    String skinColor;
    String eyeColor;
    String birthYear;
    PlanetDto homeworld;
    List<StarshipDto> starships;
}
