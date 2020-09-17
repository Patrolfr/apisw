package go.fraczek.apisw.common

import go.fraczek.apisw.common.UrlIdExtractor
import org.assertj.core.api.Assertions
import spock.lang.Specification

class UrlIdExtractorTest extends Specification {

    private static final EXPECTED_ID = 123L

    private static final VALID_URL = '/some/path/with/id/at/the/end/' + EXPECTED_ID
    private static final VALID_URL_WITH_SLASH = '/some/path/with/id/and/slash/at/the/end/' + EXPECTED_ID + '/'
    private static final VALID_URL_TWO_IDS = '/path/with/two/ids/and/at/the/end/55/' + EXPECTED_ID + '/'
    private static final INVALID_URL_EMPTY = ''
    private static final INVALID_URL_NULL = null
    private static final INVALID_URL_NO_ID = '/some/path/without/id'


    def 'given valid url with id should return Optional of id'() {
        when:
        def extractedId = UrlIdExtractor.extractId(testUrl)

        then:
        Assertions.assertThat(extractedId).isEqualTo(expectedId)

        where:
        testUrl              | expectedId
        VALID_URL            | Optional.of(EXPECTED_ID)
        VALID_URL_WITH_SLASH | Optional.of(EXPECTED_ID)
        VALID_URL_TWO_IDS    | Optional.of(EXPECTED_ID)
    }

    def 'given bad url should return empty Optional'() {
        when:
        def extractedId = UrlIdExtractor.extractId(testUrl)

        then:
        Assertions.assertThat(extractedId).isEqualTo(expectedId)

        where:
        testUrl              | expectedId
        INVALID_URL_EMPTY    | Optional.empty()
        INVALID_URL_NULL     | Optional.empty()
        INVALID_URL_NO_ID    | Optional.empty()
    }
}
