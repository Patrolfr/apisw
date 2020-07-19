package go.fraczek.apisw.character.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CharacterPageDto {

    private int count;
    private int pages;
    private List<CharacterDto> elements;
}
