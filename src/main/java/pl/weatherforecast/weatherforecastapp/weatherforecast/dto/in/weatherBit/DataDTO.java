package pl.weatherforecast.weatherforecastapp.weatherforecast.dto.in.weatherBit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO {

    @JsonProperty("rh")
    private int rh;

    @JsonProperty("pod")
    private String pod;

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("pres")
    private double pressure;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("ob_time")
    private String observationTime;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("clouds")
    private int clouds;

    @JsonProperty("ts")
    private Date ts;

    @JsonProperty("solar_rad")
    private double solarRad;

    @JsonProperty("state_code")
    private String stateCode;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("wind_spd")
    private double windSpeed;

    @JsonProperty("wind_cdir_full")
    private String windDirectionFull;

    @JsonProperty("wind_cdir")
    private String windDirection;

    @JsonProperty("slp")
    private int slp;

    @JsonProperty("vis")
    private int vis;

    @JsonProperty("h_angle")
    private int h_angle;

    @JsonProperty("sunset")
    private String sunset;

    @JsonProperty("dni")
    private double dni;

    @JsonProperty("dewpt")
    private int dewpt;

    @JsonProperty("snow")
    private int snow;

    @JsonProperty("uv")
    private double uv;

    @JsonProperty("precip")
    private double precip;

    @JsonProperty("wind_dir")
    private int wind_dir;

    @JsonProperty("sunrise")
    private String sunrise;

    @JsonProperty("ghi")
    private double ghi;

    @JsonProperty("dhi")
    private double dhi;

    @JsonProperty("aqi")
    private double aqi;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("weather")
    private WeatherDTO weather;

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("station")
    private String station;

    @JsonProperty("elev_angle")
    private double elev_angle;

    @JsonProperty("app_temp")
    private double appTemp;
}
