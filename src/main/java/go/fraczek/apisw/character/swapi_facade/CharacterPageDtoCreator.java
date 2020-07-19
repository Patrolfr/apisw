package go.fraczek.apisw.character.swapi_facade;

import go.fraczek.apisw.character.model.CharacterDto;
import go.fraczek.apisw.character.model.CharacterPageDto;

import java.util.List;

class CharacterPageDtoCreator {

    private static final int SWAPI_PAGE_SIZE = 10;

    static CharacterPageDto ofElementsAndCount(List<CharacterDto> pageElements, int allElementsCount) {
        return CharacterPageDto.builder()
                .elements(pageElements)
                .count(allElementsCount)
                .pages(1 + allElementsCount / SWAPI_PAGE_SIZE)
                .build();
    }

    private CharacterPageDtoCreator() {
    }
}
