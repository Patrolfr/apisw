package go.fraczek.apisw.character.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetDto {

    private String name;
    @JsonAlias(value = "rotation_period")
    private String rotationPeriod;
    @JsonAlias(value = "orbital_period")
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @JsonAlias(value = "surface_water")
    private String surfaceWater;
    private String population;
}
