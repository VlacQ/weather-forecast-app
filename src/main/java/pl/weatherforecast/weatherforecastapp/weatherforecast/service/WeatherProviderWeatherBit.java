package pl.weatherforecast.weatherforecastapp.weatherforecast.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.weatherBit.WeatherBitDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out.WeatherForecastDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.WeatherAttributes;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class WeatherProviderWeatherBit implements WeatherProvider {

    @Value("${weatherApp.weatherBit.url}")
    private String url;

    @Value("${weatherApp.weatherBit.apiKey}")
    private String apiKey;

    @Override
    public WeatherForecastDTO getWeather(WeatherAttributes weatherAttributes) throws IOException, InterruptedException {
        URI uri = URI.create(createUrl(weatherAttributes.getLat(), weatherAttributes.getLon()));
        log.info(uri.toString());

        HttpRequest request = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        WeatherBitDTO obj = mapper.readValue(response.body(), WeatherBitDTO.class);

        return weatherForecastMapper.fromWeatherBit(obj);
    }

    private String createUrl(BigDecimal lat, BigDecimal lon){
        String latQuery = "lat=" + lat;
        String lonQuery = "lon=" + lon;
        String apiKeyQuery = "key=" + apiKey;
        return url + latQuery + AMPERSAND + lonQuery + AMPERSAND + apiKeyQuery;
    }
}
