package es.koratosun.airlines.flights.ext.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2158283846690406431L;

	public ResourceNotFoundException(String message) {
        super(message);
    }

}
