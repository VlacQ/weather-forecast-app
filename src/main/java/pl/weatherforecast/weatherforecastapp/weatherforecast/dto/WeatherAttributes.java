package pl.weatherforecast.weatherforecastapp.weatherforecast.dto;

import lombok.Getter;
import pl.weatherforecast.weatherforecastapp.weatherforecast.exception.IncorrectDataException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Getter
public class WeatherAttributes {

    private static final BigDecimal MAX = new BigDecimal("180.00");
    private static final BigDecimal MIN = new BigDecimal("-180.00");

    private BigDecimal lat;
    private BigDecimal lon;
    private EWeatherApp weatherApp;

    public WeatherAttributes(BigDecimal lat, BigDecimal lon, EWeatherApp weatherApp) {
        this.lat = validateCoords(lat);
        this.lon = validateCoords(lon);
        this.weatherApp = weatherApp;
    }

    private BigDecimal validateCoords(BigDecimal value) {
        value.setScale(3, RoundingMode.HALF_EVEN);
        Optional<BigDecimal> result = Optional.empty();
        if (value.compareTo(MAX) < 0 && value.compareTo(MIN) > 0) {
            result = Optional.of(value);
        }
        return result.orElseThrow(() -> new IncorrectDataException("Incorrect coords"));
    }
}
