package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.EWeatherApp;

import java.util.Date;
import java.util.List;

//Documentation
//https://openweathermap.org/current

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDTO {

    private final EWeatherApp application = EWeatherApp.OPEN_WEATHER;

    @JsonProperty("coord")
    private CoordsDTO coords;

    @JsonProperty("weather")
    private List<WeatherDTO> weather;

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    private MainDTO main;

    @JsonProperty("visibility")
    private int visibility;

    @JsonProperty("wind")
    private WindDTO wind;

    @JsonProperty("clouds")
    private CloudDTO clouds;

    @JsonProperty("dt")
    private Date dt;

    @JsonProperty("sys")
    private SystemDTO system;

    @JsonProperty("timezone")
    private Date timezone;

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cod")
    private int cod;

}
