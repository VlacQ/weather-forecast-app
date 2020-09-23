package pl.weatherforecast.weatherforecastapp.weatherforecast.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather.AccuWeatherDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.accuWeather.AccuWeatherLocationDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.openWeather.OpenWeatherDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.weatherBit.WeatherBitDTO;
import pl.weatherforecast.weatherforecastapp.weatherforecast.dto.out.WeatherForecastDTO;

@Mapper(componentModel = "spring")
public interface WeatherForecastMapper {

    @Mapping(expression = "java(accuWeatherLocationDTO.getCountry().getId())", target = "country")
    @Mapping(expression = "java(accuWeatherLocationDTO.getGeoPosition().getLatitude())", target = "lat")
    @Mapping(expression = "java(accuWeatherLocationDTO.getGeoPosition().getLongitude())", target = "lon")
    @Mapping(expression = "java(accuWeatherDTO.getTemperature().getMetric().getValue())", target = "temp")
    @Mapping(expression = "java(accuWeatherDTO.getRealFeelTemperature().getMetric().getValue())", target = "feelTemp")
    @Mapping(expression = "java(accuWeatherDTO.getWind().getSpeed().getMetric().getValue())", target = "windSpeed")
    @Mapping(expression = "java(accuWeatherDTO.getPressure().getMetric().getValue())", target = "pressure")
    @Mapping(expression = "java(accuWeatherDTO.getWeatherText())", target = "description")
    WeatherForecastDTO fromAccuWeather(AccuWeatherDTO accuWeatherDTO, AccuWeatherLocationDTO accuWeatherLocationDTO);

    @Mapping(expression = "java(openWeatherDTO.getSystem().getCountry())", target = "country")
    @Mapping(expression = "java(openWeatherDTO.getCoords().getLat())", target = "lat")
    @Mapping(expression = "java(openWeatherDTO.getCoords().getLon())", target = "lon")
    @Mapping(expression = "java(openWeatherDTO.getMain().getTemp())", target = "temp")
    @Mapping(expression = "java(openWeatherDTO.getMain().getFeelsLike())", target = "feelTemp")
    @Mapping(expression = "java(openWeatherDTO.getWind().getSpeed())", target = "windSpeed")
    @Mapping(expression = "java(openWeatherDTO.getMain().getPressure())", target = "pressure")
    @Mapping(expression = "java(openWeatherDTO.getWeather().get(0).getDescription())", target = "description")
    WeatherForecastDTO fromOpenWeather(OpenWeatherDTO openWeatherDTO);

    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getCountryCode())", target = "country")
    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getLat())", target = "lat")
    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getLon())", target = "lon")
    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getTemp())", target = "temp")
    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getAppTemp())", target = "feelTemp")
    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getWindSpeed())", target = "windSpeed")
    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getPressure())", target = "pressure")
    @Mapping(expression = "java(weatherBitDTO.getData().get(0).getWeather().getDescription())", target = "description")
    WeatherForecastDTO fromWeatherBit(WeatherBitDTO weatherBitDTO);
}
