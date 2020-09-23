package pl.weatherforecast.weatherforecastapp.weatherforecast.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out.WeatherForecastDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.exception.FailedDependencyException;
import pl.weatherforecast.weatherforecastapp.weatherforecast.exception.IncorrectApplicationException;
import pl.weatherforecast.weatherforecastapp.weatherforecast.exception.NotFoundException;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.WeatherAttributes;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeatherForecastService {

    private final WeatherProviderOpenWeather weatherProviderOpenWeather;
    private final WeatherProviderWeatherBit weatherProviderWeatherBit;
    private final WeatherProviderAccuWeather weatherProviderAccuWeather;

    public List<WeatherForecastDTO> getCurrentWeather(WeatherAttributes weatherAttributes){
        Optional<List<WeatherForecastDTO>> list;

        switch (weatherAttributes.getWeatherApp()){
            case ALL:
                list = getCurrentWeatherFromAllApps(weatherAttributes);
                break;
            case ACCU_WEATHER:
                list = getCurrentWeatherFromAccuWeather(weatherAttributes);
                break;
            case OPEN_WEATHER:
                list = getCurrentWeatherFromOpenWeather(weatherAttributes);
                break;
            case WEATHER_BIT:
                list = getCurrentWeatherFromWeatherBit(weatherAttributes);
                break;
            default:
                throw new IncorrectApplicationException();
        }

        return list.orElseThrow(() -> new NotFoundException("Missing data"));
    }

    private Optional<List<WeatherForecastDTO>> getCurrentWeatherFromOpenWeather(WeatherAttributes weatherAttributes){
        List<WeatherForecastDTO> list = new LinkedList<>();
        try {
            list.add(weatherProviderOpenWeather.getWeather(weatherAttributes));
        } catch (InterruptedException | IOException e) {
            throw new FailedDependencyException();
        }
        return Optional.of(list);
    }

    private Optional<List<WeatherForecastDTO>> getCurrentWeatherFromWeatherBit(WeatherAttributes weatherAttributes){
        List<WeatherForecastDTO> list = new LinkedList<>();
        try {
            list.add(weatherProviderWeatherBit.getWeather(weatherAttributes));
        } catch (InterruptedException | IOException e) {
            throw new FailedDependencyException();
        }
        return Optional.of(list);
    }

    private Optional<List<WeatherForecastDTO>> getCurrentWeatherFromAccuWeather(WeatherAttributes weatherAttributes){
        List<WeatherForecastDTO> list = new LinkedList<>();
        try {
            list.add(weatherProviderAccuWeather.getWeather(weatherAttributes));
        } catch (InterruptedException | IOException e) {
            throw new FailedDependencyException();
        }
        return Optional.of(list);
    }

    private Optional<List<WeatherForecastDTO>> getCurrentWeatherFromAllApps(WeatherAttributes weatherAttributes){
        List<WeatherForecastDTO> list = new LinkedList<>();
        try {
            list.add(weatherProviderOpenWeather.getWeather(weatherAttributes));
            list.add(weatherProviderWeatherBit.getWeather(weatherAttributes));
            list.add(weatherProviderAccuWeather.getWeather(weatherAttributes));
        } catch (InterruptedException | IOException e) {
            throw new FailedDependencyException();
        }
        return Optional.of(list);
    }
}
