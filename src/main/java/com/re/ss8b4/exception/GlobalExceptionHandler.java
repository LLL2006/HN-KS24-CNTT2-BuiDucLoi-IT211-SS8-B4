package com.re.ss8b4.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(
            ResourceNotFoundException ex
    ) {

        Map<String, Object> map = new HashMap<>();

        map.put("status", 404);
        map.put("error", "Not Found");
        map.put("message", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDenied(
            AccessDeniedException ex
    ) {

        Map<String, Object> map = new HashMap<>();

        map.put("status", 403);
        map.put("error", "Forbidden");
        map.put("message", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(map, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(
            ConstraintViolationException ex
    ) {

        Map<String, Object> map = new HashMap<>();

        map.put("status", 400);
        map.put("error", "Bad Request");
        map.put("message", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(
            Exception ex
    ) {

        Map<String, Object> map = new HashMap<>();

        map.put("status", 500);
        map.put("error", "Internal Server Error");
        map.put("message", ex.getMessage());
        map.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(
                map,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
