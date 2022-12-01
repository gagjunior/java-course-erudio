package br.com.gagjunior.calculator.exceptions.handler;

import br.com.gagjunior.calculator.exceptions.ResponseException;
import br.com.gagjunior.calculator.exceptions.UnsuportedOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseException> handleAllExceptions(Exception e, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDate.now(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsuportedOperationException.class)
    public final ResponseEntity<ResponseException> handleBadExceptions(Exception e, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDate.now(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
    }
}
