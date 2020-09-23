package pl.weatherforecast.weatherforecastapp.weatherforecast.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class FailedDependencyException extends RuntimeException {
    public FailedDependencyException(){

    }
}
