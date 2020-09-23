package pl.weatherforecast.weatherforecastapp.weatherforecast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.EWeatherApp;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out.WeatherForecastDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.WeatherAttributes;
import pl.weatherforecast.weatherforecastapp.weatherforecast.service.WeatherForecastService;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class WeatherForecastController {

    private final WeatherForecastService weatherForecastService;

    @GetMapping
    public ResponseEntity<List<WeatherForecastDTO>> getCurrentWeather(@RequestParam EWeatherApp weatherApp,
                                                                      @RequestParam BigDecimal lat,
                                                                      @RequestParam BigDecimal lon){
        WeatherAttributes weatherAttributes = new WeatherAttributes(lat, lon, weatherApp);
        return ResponseEntity.ok(weatherForecastService.getCurrentWeather(weatherAttributes));
    }
}
