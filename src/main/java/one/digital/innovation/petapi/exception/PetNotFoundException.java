package one.digital.innovation.petapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetNotFoundException extends Exception {
    public PetNotFoundException(Long id) {
        super("Person not found with ID: " + id );
    }
}
