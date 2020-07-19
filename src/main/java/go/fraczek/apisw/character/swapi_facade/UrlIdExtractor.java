package go.fraczek.apisw.character.swapi_facade;

import java.util.Optional;

class UrlIdExtractor {

    static Optional<Long> extractId(String resourceUrl) {
        if(resourceUrl == null) {
            return Optional.empty();
        }

        String[] partialUrl = resourceUrl.split("/");

        try {
            return Optional.of(Long.valueOf(partialUrl[partialUrl.length - 1]));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    private UrlIdExtractor() {
    }
}
