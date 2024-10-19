package com.tjk.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles IllegalArgumentExceptions
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage()); // Restituisce il messaggio dell'eccezione
    }

    // Handles UserNotFoundExceptions
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found: " + ex.getMessage());
    }

    // Handles DeckNotFoundException
    @ExceptionHandler(DeckNotFoundException.class)
    public ResponseEntity<String> handleDeckNotFoundException(DeckNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deck Not Found: " + ex.getMessage());
    }

    // Handles CardNotFoundException
    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<String> handleCardNotFoundException(CardNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card Not Found: " + ex.getMessage());
    }

    // Handles EmptyCollectionException
    @ExceptionHandler(EmptyCollectionException.class)
    public ResponseEntity<String> handleEmptyCollectionException(EmptyCollectionException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty Collection: " + ex.getMessage());
    }

    // Handles DeckValidationException
    @ExceptionHandler(DeckValidationException.class)
    public ResponseEntity<String> handleDeckValidationException(DeckValidationException ex, WebRequest request) {
        return ResponseEntity.badRequest().body("Deck Validation Error: " + ex.getMessage());
    }

    // Handles any unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + ex.getMessage());
    }

    // Handles parameter validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
}
