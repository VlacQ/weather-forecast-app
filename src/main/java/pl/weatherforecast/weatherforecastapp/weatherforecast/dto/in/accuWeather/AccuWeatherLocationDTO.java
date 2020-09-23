package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccuWeatherLocationDTO {

    @JsonProperty("Key")
    private int id;

    @JsonProperty("Country")
    private Country country;

    @JsonProperty("GeoPosition")
    private GeoPosition geoPosition;
}
