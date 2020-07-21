package go.fraczek.apisw.character

import go.fraczek.apisw.HttpIntegrationTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
class CharacterIntegrationTest extends HttpIntegrationTest {

    private static final SWAPI_PEOPLE_PAGE_URL = '/api/people/?page='
    private static final SWAPI_PEOPLE_URL = '/api/people/'
    private static final SWAPI_PLANETS_URL = '/api/planets/'
    private static final SWAPI_STARSHIPS_URL = '/api/starships/'

    private static final FIRST_CHARACTER_PAGE_URL = '/characters/?page=1'
    private static final CHARACTER_URL = '/characters/'
    private static final FIRST_CHARACTER_URL = CHARACTER_URL + '1'

    @Autowired
    MockMvc mockMvc

    def 'given swapi api error 4xx or 5xx should return message'() {
        given:
        'swapi ' + status + ' response status'
        customStubFor(swapiPeopleUrl(500), {
            response -> response.withStatus(status).withBody(body)
        })

        when: 'get for character with id 500'
        def result = mockMvc.perform(MockMvcRequestBuilders.get(characterUrl(500)))

        then: 'should return 404 with swapi error status message'
        result
                .andExpect(status().isNotFound())
                .andExpect(jsonPath('$.msg').value('Swapi error, API responded with status ' + status))
        where:
        status | body
        400    | 'some bad request msg'
        500    | 'internal server error'
    }

    def 'given not present swapi people page resource should return 404'() {
        given: 'no stubs'

        when: 'get for character with id 1'
        def result = mockMvc.perform(MockMvcRequestBuilders.get(FIRST_CHARACTER_PAGE_URL))

        then: 'should return 404 with message'
        result
                .andExpect(status().isNotFound())
                .andExpect(jsonPath('$.msg').value('Page 1 not found.'))
    }

    def 'given not present swapi people resource should return 404'() {
        given: 'no stubs'

        when: 'get for page 1'
        def result = mockMvc.perform(MockMvcRequestBuilders.get(FIRST_CHARACTER_URL))

        then: 'should return 404 with message'
        result
                .andExpect(status().isNotFound())
                .andExpect(jsonPath('$.msg').value('Character with id 1 not found.'))
    }

    def 'given present swapi people page resource should return valid character'() {
        given: 'stubbed swapi page response'
        def pageNumber = 1
        customStubFor(swapiPeoplePageUrl(pageNumber),
                { response -> response.withBody(CharacterModels.getLukeAndC3POPage()) }
        )

        when: 'get for page 1'
        def results = mockMvc.perform(MockMvcRequestBuilders.get(FIRST_CHARACTER_PAGE_URL))

        then: 'should return 200 valid page response'
        results
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.pages').value(pageNumber))
                .andExpect(jsonPath('$.count').value(2))
                .andExpect(jsonPath('$.elements[0].name').value('Luke Skywalker'))
                .andExpect(jsonPath('$.elements[1].name').value('C-3PO'))
    }

    def 'given inconsistent swapi responses should still return valid character'() {
        given: 'stubbed swapi people response but not stubbed planet and starship'
        def luke = CharacterModels.getLuke()
        customStubFor(swapiPeopleUrl(1))

        when: 'get for character with id 1'
        def result = mockMvc.perform(MockMvcRequestBuilders.get(FIRST_CHARACTER_URL))

        then: 'should return 200 valid character response with null homeworld and empty starships'
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.name').value(luke.getString('name')))
                .andExpect(jsonPath('$.homeworld').value(null))
                .andExpect(jsonPath('$.starships').value([]))
    }

    def 'given consistent swapi responses should return valid character'() {
        given: 'stubbed swapi people, homeworld, starship response'
        def luke = CharacterModels.getLuke()
        def tatooine = CharacterModels.getTatooine()
        def xWing = CharacterModels.getXWing()
        customStubFor(swapiPeopleUrl(1))
        customStubFor(swapiPlanetsUrl(1), {response -> response.withBody(tatooine.toString())})
        customStubFor(swapiStarshipsUrl(12), {response -> response.withBody(xWing.toString())})

        when: 'get for character with id 1'
        def result = mockMvc.perform(MockMvcRequestBuilders.get(FIRST_CHARACTER_URL))

        then: 'should return 200 valid character response with homeworld and starships'
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.name').value(luke.getString('name')))
                .andExpect(jsonPath('$.homeworld.name').value(tatooine.getString('name')))
                .andExpect(jsonPath('$.homeworld.orbitalPeriod').value(tatooine.getString('orbital_period')))
                .andExpect(jsonPath('$.starships[0].name').value(xWing.getString('name')))
                .andExpect(jsonPath('$.starships[0].maxAtmosphericSpeed').value(xWing.getString('max_atmosphering_speed')))
    }

    private static def swapiPeoplePageUrl(page) {
        return SWAPI_PEOPLE_PAGE_URL + page
    }

    private static def swapiPeopleUrl(id) {
        return SWAPI_PEOPLE_URL + id + '/'
    }

    private static def swapiPlanetsUrl(id) {
        return SWAPI_PLANETS_URL + id + '/'
    }

    private static def swapiStarshipsUrl(id) {
        return SWAPI_STARSHIPS_URL + id + '/'
    }

    private static def characterUrl(id) {
        return CHARACTER_URL + id
    }
}
