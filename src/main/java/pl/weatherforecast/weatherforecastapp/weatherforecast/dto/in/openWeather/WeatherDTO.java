package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {
    @JsonProperty("id")
    int id;
    @JsonProperty("main")
    String main;
    @JsonProperty("description")
    String description;
    @JsonProperty("icon")
    String icon;
}
