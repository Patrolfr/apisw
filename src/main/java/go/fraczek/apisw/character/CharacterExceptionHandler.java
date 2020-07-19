package go.fraczek.apisw.character;

import go.fraczek.apisw.character.swapi_facade.exception.SwapiResourceNotFoundRuntimeExc;
import go.fraczek.apisw.character.swapi_facade.exception.SwapiServiceUnavailableRuntimeExc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
class CharacterExceptionHandler {

    @ExceptionHandler(value = SwapiResourceNotFoundRuntimeExc.class)
    ResponseEntity<Map<String, String>> hangleCharacterNotFoundException(SwapiResourceNotFoundRuntimeExc e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("msg", e.getMessage()));
    }

    @ExceptionHandler(value = SwapiServiceUnavailableRuntimeExc.class)
    ResponseEntity<Map<String, String>> hangleSwapiServiceUnavilableException(SwapiServiceUnavailableRuntimeExc e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("msg", e.getMessage()));
    }
}
