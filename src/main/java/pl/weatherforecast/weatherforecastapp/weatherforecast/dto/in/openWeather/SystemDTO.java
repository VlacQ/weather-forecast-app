package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemDTO {
    @JsonProperty("type")
    private int type;
    @JsonProperty("id")
    private int id;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sunrise")
    private Date sunrise;
    @JsonProperty("sunset")
    private Date sunset;
}
