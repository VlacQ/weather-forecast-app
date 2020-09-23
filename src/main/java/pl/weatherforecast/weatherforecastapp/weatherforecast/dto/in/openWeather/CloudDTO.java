package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudDTO {
    @JsonProperty("all")
    private int all;
}
