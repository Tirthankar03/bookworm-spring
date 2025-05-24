package com.aun1x.bookworm.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record ApiError(
        String path,
        String message,
        int statusCode,
        String timestamp
) {
    public ApiError(String path, String message, int statusCode, LocalDateTime localDateTime) {
        this(path, message, statusCode, localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}