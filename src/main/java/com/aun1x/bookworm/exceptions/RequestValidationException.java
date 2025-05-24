package com.aun1x.bookworm.exceptions;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class RequestValidationException extends RuntimeException {
    private final Map<String, List<String>> errors;

    public RequestValidationException(String message, Map<String, List<String>> errors) {
        super(message);
        this.errors = errors;
    }

}