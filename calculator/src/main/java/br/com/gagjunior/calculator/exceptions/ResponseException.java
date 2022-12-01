package br.com.gagjunior.calculator.exceptions;

import java.io.Serializable;
import java.time.LocalDate;

public class ResponseException implements Serializable {

    private final LocalDate timestamp;
    private final String message;
    private final String details;

    public ResponseException(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
