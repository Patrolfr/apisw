package go.fraczek.apisw.character.swapi_facade;

import feign.Response;
import feign.codec.ErrorDecoder;
import go.fraczek.apisw.character.swapi_facade.exception.SwapiServiceUnavailableRuntimeExc;

class SwapiErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return new SwapiServiceUnavailableRuntimeExc(
                String.format("Swapi error, API responded with status %d", response.status())
        );
    }
}
