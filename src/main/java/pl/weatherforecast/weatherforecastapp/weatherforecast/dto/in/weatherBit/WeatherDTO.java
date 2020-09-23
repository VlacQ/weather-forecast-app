package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.weatherBit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {
    @JsonProperty("icon")
    private String icon;

    @JsonProperty("code")
    private int code;

    @JsonProperty("description")
    private String description;
}
