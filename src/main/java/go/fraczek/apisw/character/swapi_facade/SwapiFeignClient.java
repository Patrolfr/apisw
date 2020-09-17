package go.fraczek.apisw.character.swapi_facade;

import go.fraczek.apisw.character.model.PlanetDto;
import go.fraczek.apisw.character.model.StarshipDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Component
@FeignClient(name = "${feign.client.name}", url = "${feign.client.url}", decode404 = true)
interface SwapiFeignClient {

    @GetMapping(value = "/people/")
    Optional<PeoplePageResponse> getPeoplePageByPageNumber(@RequestParam("page") long page);

    @GetMapping(value = "/people/{id}/")
    Optional<PeopleResponse> getPeopleById(@PathVariable("id") long id);

    @GetMapping(value = "/planets/{id}/")
    Optional<PlanetDto> getPlanetById(@PathVariable("id") long id);

    @GetMapping(value = "/starships/{id}/")
    Optional<StarshipDto> getStarshipById(@PathVariable("id") long id);
}
