package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.weatherBit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.EWeatherApp;

import java.util.List;

//Documentation
//https://www.weatherbit.io/api/weather-current

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherBitDTO {

    private final EWeatherApp application = EWeatherApp.WEATHER_BIT;

    @JsonProperty("data")
    private List<DataDTO> data;

    @JsonProperty("count")
    private int count;
}
