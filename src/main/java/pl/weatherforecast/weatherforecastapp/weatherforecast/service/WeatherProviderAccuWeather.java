package pl.weatherforecast.weatherforecastapp.weatherforecast.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather.AccuWeatherDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather.AccuWeatherLocationDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out.WeatherForecastDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.WeatherAttributes;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class WeatherProviderAccuWeather implements WeatherProvider {

    @Value("${weatherApp.accuWeather.url}")
    private String url;

    @Value("${weatherApp.accuWeather.urlLocation}")
    private String urlLocation;

    @Value("${weatherApp.accuWeather.apiKey}")
    private String apiKey;

    @Override
    public WeatherForecastDTO getWeather(WeatherAttributes weatherAttributes) throws IOException, InterruptedException {
        AccuWeatherLocationDTO accuWeatherLocationDTO = getLocation(weatherAttributes.getLat(), weatherAttributes.getLon());
        int id = accuWeatherLocationDTO.getId();
        URI uri = URI.create(createUrl(id));

        log.info(uri.toString());

        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        AccuWeatherDTO[] obj = mapper.readValue(response.body(), AccuWeatherDTO[].class);

        return weatherForecastMapper.fromAccuWeather(obj[0], accuWeatherLocationDTO);
    }

    private AccuWeatherLocationDTO getLocation(BigDecimal lat, BigDecimal lon) throws IOException, InterruptedException {
        URI uri = URI.create(createLocationUrl(lat, lon));

        log.info(uri.toString());

        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(response.body(), AccuWeatherLocationDTO.class);
    }

    private String createLocationUrl(BigDecimal lat, BigDecimal lon){
        String latLotQuery = "q=" + lat + "," + lon;
        String apiKeyQuery = "apikey=" + apiKey;
        return urlLocation + latLotQuery + AMPERSAND + apiKeyQuery;
    }

    private String createUrl(int id){
        String apiKeyQuery = "apikey=" + apiKey;
        return url + id + "?details=true" + AMPERSAND + apiKeyQuery;
    }
}
