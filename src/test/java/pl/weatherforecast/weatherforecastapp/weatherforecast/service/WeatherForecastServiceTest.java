package pl.weatherforecast.weatherforecastapp.weatherforecast.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.EWeatherApp;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.WeatherAttributes;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out.WeatherForecastDTO;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherForecastServiceTest {

    @Autowired
    private WeatherForecastService wfs;

    @Test
    void getCurrentWeatherAllApps() {
        WeatherAttributes wa =
                new WeatherAttributes(new BigDecimal("50"), new BigDecimal("20.123"), EWeatherApp.ALL);
        List<WeatherForecastDTO> list = wfs.getCurrentWeather(wa);
        assertEquals(3, list.size());
        assertNotNull(list.get(0));
        assertNotNull(list.get(1));
        assertNotNull(list.get(2));
    }

    @Test
    void getCurrentWeatherAccuWeather() {
        WeatherAttributes wa =
                new WeatherAttributes(new BigDecimal("50"), new BigDecimal("20.123"), EWeatherApp.ACCU_WEATHER);
        List<WeatherForecastDTO> list = wfs.getCurrentWeather(wa);
        assertEquals(1, list.size());
        assertNotNull(list.get(0));
    }

    @Test
    void getCurrentWeatherOpenWeather() {
        WeatherAttributes wa =
                new WeatherAttributes(new BigDecimal("70"), new BigDecimal("15.784"), EWeatherApp.OPEN_WEATHER);
        List<WeatherForecastDTO> list = wfs.getCurrentWeather(wa);
        assertEquals(1, list.size());
        assertNotNull(list.get(0));
    }

    @Test
    void getCurrentWeatherWeatherBit() {
        WeatherAttributes wa =
                new WeatherAttributes(new BigDecimal("50"), new BigDecimal("20.123"), EWeatherApp.WEATHER_BIT);
        List<WeatherForecastDTO> list = wfs.getCurrentWeather(wa);
        assertEquals(1, list.size());
        assertNotNull(list.get(0));
    }
}
