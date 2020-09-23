package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.EWeatherApp;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccuWeatherDTO {

    private final EWeatherApp application = EWeatherApp.ACCU_WEATHER;

    @JsonProperty("WeatherText")
    private String weatherText;

    @JsonProperty("Temperature")
    private Parameter temperature;

    @JsonProperty("RealFeelTemperature")
    private Parameter realFeelTemperature;

    @JsonProperty("Wind")
    private Wind wind;

    @JsonProperty("Pressure")
    private Parameter pressure;
}
