package pl.weatherforecast.weatherforecastapp.weatherforecast.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out.WeatherForecastDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.mapper.WeatherForecastMapper;
import pl.weatherforecast.weatherforecastapp.weatherforecast.mapper.WeatherForecastMapperImpl;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.WeatherAttributes;

import java.io.IOException;
import java.net.http.HttpClient;

public interface WeatherProvider {

    public final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public final ObjectMapper mapper = new ObjectMapper();

    public final WeatherForecastMapper weatherForecastMapper = new WeatherForecastMapperImpl();

    public static final String AMPERSAND = "&";

    WeatherForecastDTO getWeather(WeatherAttributes weatherAttributes) throws IOException, InterruptedException;
}
