package go.fraczek.apisw.character;

import go.fraczek.apisw.character.model.CharacterDto;
import go.fraczek.apisw.character.model.CharacterPageDto;
import go.fraczek.apisw.character.swapi_facade.SwapiFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class CharacterController {

    private final SwapiFacade swapiFacade;

    @GetMapping(value = "/characters/")
    public ResponseEntity<CharacterPageDto> getCharactersPage(
            @RequestParam(required = false, defaultValue = "1") long page) {
        return ResponseEntity.ok(swapiFacade.getCharactersPage(page));
    }

    @GetMapping(value = "/characters/{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable long id) {
        return ResponseEntity.ok(swapiFacade.getCharacterById(id));
    }
}
