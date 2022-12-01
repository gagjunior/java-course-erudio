package br.com.gagjunior.calculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedOperationException extends RuntimeException {

    public UnsuportedOperationException(String exception) {
        super(exception);
    }
}
