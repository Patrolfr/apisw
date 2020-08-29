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
        return new CharacterDto(
                peopleResponse.getName(),
                peopleResponse.getHeight(),
                peopleResponse.getMass(),
                peopleResponse.getHairColor(),
                peopleResponse.getSkinColor(),
                peopleResponse.getEyeColor(),
                peopleResponse.getBirthYear(),
                homeworld,
                starships
        );
    }

    private CharacterDtoCreator() {
    }
}
