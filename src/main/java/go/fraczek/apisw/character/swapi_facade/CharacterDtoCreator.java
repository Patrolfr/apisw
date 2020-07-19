package go.fraczek.apisw.character.swapi_facade;

import go.fraczek.apisw.character.model.CharacterDto;
import go.fraczek.apisw.character.model.PlanetDto;
import go.fraczek.apisw.character.model.StarshipDto;

import java.util.List;

class CharacterDtoCreator {

    static CharacterDto createFromResourceParts(
            PlanetDto homeworld,
            PeopleResponse peopleResponse,
            List<StarshipDto> starships
    ) {
        return CharacterDto.builder()
                .name(peopleResponse.getName())
                .height(peopleResponse.getHeight())
                .mass(peopleResponse.getMass())
                .hairColor(peopleResponse.getHairColor())
                .skinColor(peopleResponse.getSkinColor())
                .eyeColor(peopleResponse.getEyeColor())
                .birthYear(peopleResponse.getBirthYear())
                .homeworld(homeworld)
                .starships(starships)
                .build();
    }

    private CharacterDtoCreator() {
    }
}
