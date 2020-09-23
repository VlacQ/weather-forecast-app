package pl.weatherforecast.weatherforecastapp.weatherforecast.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectApplicationException extends RuntimeException {
    public IncorrectApplicationException(){ }
}
