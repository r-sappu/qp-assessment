package com.GroceryApplication.api.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.JsonParseException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(JsonParseException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getLocalizedMessage());
        errors.put("message", "Please send a valid json.");
        
        logger.error("Json Parsing error sending response.");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ex.getConstraintViolations().forEach((x)-> sb.append(x.getMessage()));
        errors.put("error", sb.toString());
        errors.put("message", "Please send a valid json.");
        logger.error("Constraint Violation error sending response.");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
}
