package go.fraczek.apisw.character.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarshipDto {

    private String name;
    private String model;
    private String manufacturer;
    @JsonAlias(value = "cost_in_credits")
    private String costInCredits;
    private String length;
    @JsonAlias(value = "max_atmosphering_speed")
    private String maxAtmosphericSpeed;
    private String crew;
    private String passengers;
    @JsonAlias(value = "cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @JsonAlias(value = "hyperdrive_rating")
    private String hyperdriveRating;
    private String mglt;
    @JsonAlias(value = "starship_class")
    private String starshipClass;
}
