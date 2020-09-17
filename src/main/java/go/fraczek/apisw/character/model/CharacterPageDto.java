package go.fraczek.apisw.character.model;

import lombok.Value;

import java.util.List;

@Value
public class CharacterPageDto {

    int count;
    List<CharacterDto> elements;
    int pages;
}
