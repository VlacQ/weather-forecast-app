package pl.weatherforecast.weatherforecastapp.weatherforecast.dto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.weatherforecast.weatherforecastapp.weatherforecast.exception.IncorrectDataException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherAttributesTest {

    @Test
    void correctData() {
        WeatherAttributes weatherAttributes =
                new WeatherAttributes(new BigDecimal("50"), new BigDecimal("20.123"), EWeatherApp.ALL);

        assertNotNull(weatherAttributes);
        assertEquals(new BigDecimal("50"), weatherAttributes.getLat());
        assertEquals(new BigDecimal("20.123"), weatherAttributes.getLon());
        assertEquals(EWeatherApp.ALL, weatherAttributes.getWeatherApp());
    }

    @Test
    void incorrectData() {
        assertThrows(IncorrectDataException.class, () -> {
            new WeatherAttributes(new BigDecimal("500"), new BigDecimal("20.123"), EWeatherApp.ALL);
        });
        assertThrows(IncorrectDataException.class, () -> {
            new WeatherAttributes(new BigDecimal("50"), new BigDecimal("200.123"), EWeatherApp.ALL);
        });
    }
}
