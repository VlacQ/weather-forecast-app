package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.EWeatherApp;

@Getter
@Setter
@Builder
public class WeatherForecastDTO {
    private EWeatherApp application;
    private String country;
    private double lat;
    private double lon;
    private double temp;
    private double feelTemp;
    private double windSpeed;
    private double pressure;
    private String description;
}
