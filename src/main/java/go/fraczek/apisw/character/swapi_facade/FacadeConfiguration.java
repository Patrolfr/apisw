package go.fraczek.apisw.character.swapi_facade;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FacadeConfiguration {

    @Bean SwapiFacade swapiFacade(SwapiFeignClient feignClient) {
        return new SwapiFacadeFeignImpl(feignClient);
    }

    @Bean
    ErrorDecoder swapiErrorDecoder() {
        return new SwapiErrorDecoder();
    }
}
