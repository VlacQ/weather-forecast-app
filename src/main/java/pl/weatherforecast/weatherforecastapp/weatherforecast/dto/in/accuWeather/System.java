package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class System {

    @JsonProperty("Value")
    private double value;

    @JsonProperty("Unit")
    private String unit;

    @JsonProperty("UnitType")
    private String unitType;
}
