package go.fraczek.apisw.character.swapi_facade;

import go.fraczek.apisw.character.model.CharacterDto;
import go.fraczek.apisw.character.model.CharacterPageDto;
import go.fraczek.apisw.character.swapi_facade.exception.SwapiResourceNotFoundRuntimeExc;

public interface SwapiFacade {

    CharacterDto getCharacterById(long id) throws SwapiResourceNotFoundRuntimeExc;
    CharacterPageDto getCharactersPage(long page) throws SwapiResourceNotFoundRuntimeExc;
}
