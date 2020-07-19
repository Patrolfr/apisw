package go.fraczek.apisw.character.swapi_facade;

import go.fraczek.apisw.character.model.CharacterDto;
import go.fraczek.apisw.character.model.CharacterPageDto;
import go.fraczek.apisw.character.model.PlanetDto;
import go.fraczek.apisw.character.model.StarshipDto;
import go.fraczek.apisw.character.swapi_facade.exception.SwapiResourceNotFoundRuntimeExc;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
class SwapiFacadeFeignImpl implements SwapiFacade {

    private static final Logger logger = LoggerFactory.getLogger(SwapiFacadeFeignImpl.class);

    private final SwapiFeignClient swapiFeignClient;

    @Override
    public CharacterPageDto getCharactersPage(long page) {
        return swapiFeignClient.getPeoplePageByPageNumber(page)
                .map(this::convertPeoplePageToCharacterPage)
                .orElseThrow(() -> new SwapiResourceNotFoundRuntimeExc(String.format("Page %d not found.", page)));
    }

    @Override
    public CharacterDto getCharacterById(long id) {
        return swapiFeignClient.getPeopleById(id)
                .map(this::convertPeopleToCharacter)
                .orElseThrow(() -> new SwapiResourceNotFoundRuntimeExc(String.format("Character with id %d not found.", id)));
    }

    private CharacterPageDto convertPeoplePageToCharacterPage(PeoplePageResponse pageResponse) {
        return CharacterPageDtoCreator.ofElementsAndCount(
                pageResponse.getResults().stream().map(this::convertPeopleToCharacter).collect(toList()),
                pageResponse.getCount()
        );
    }

    private CharacterDto convertPeopleToCharacter(PeopleResponse peopleResponse) {
        return CharacterDtoCreator.createFromResourceParts(
                fetchPlanetByUrl(peopleResponse.getHomeworld()),
                peopleResponse,
                fetchStarshipsByUrls(peopleResponse.getStarships())
        );
    }

    private PlanetDto fetchPlanetByUrl(String planetResourceUrl) {
        return  UrlIdExtractor.extractId(planetResourceUrl)
                .flatMap(swapiFeignClient::getPlanetById)
                .orElseGet(() -> {
                    logNestedResourceNotFoundWarning(planetResourceUrl);
                    return null;
                });
    }

    private List<StarshipDto> fetchStarshipsByUrls(List<String> starshipUrls) {
        if (starshipUrls == null || starshipUrls.isEmpty()) {
            return Collections.emptyList();
        }

        return starshipUrls
                .stream()
                .map(this::fetchStarshipByResourceUrl)
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private StarshipDto fetchStarshipByResourceUrl(String starshipResourceUrl) {
        return UrlIdExtractor.extractId(starshipResourceUrl)
                .flatMap(swapiFeignClient::getStarshipById)
                .orElseGet(() -> {
                    logNestedResourceNotFoundWarning(starshipResourceUrl);
                    return null;
                });
    }

    private void logNestedResourceNotFoundWarning(String hateoasUrl) {
        logger.warn(String.format("Character nested resource not found. \n" +
                "Could not reach nested hateoas resource %s from swapi.dev." +
                "Character response body may be inconsistent. Please verify resource url.", hateoasUrl));
    }
}
