package go.fraczek.apisw

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import go.fraczek.apisw.character.CharacterModels
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import java.util.function.Consumer

import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureWireMock(port = 8087)
abstract class HttpIntegrationTest extends Specification {

    protected static def customStubFor(url) {
        customStubFor(url, {})
    }

    protected static def customStubFor(url, Consumer<ResponseDefinitionBuilder> customResponse) {
        def responseBuilder = WireMock.aResponse()
                .withStatus(200)
                .withHeader('Content-Type', 'application/json; charset=utf-8')
                .withBody(CharacterModels.getLuke().toString())

        customResponse.accept(responseBuilder)

        WireMock.stubFor(
                WireMock.get(urlEqualTo(url))
                        .willReturn(responseBuilder)
        )
    }
}
