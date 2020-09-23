package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameter {

    @JsonProperty("Metric")
    private System metric;

    @JsonProperty("Imperial")
    private System imperial;

}
