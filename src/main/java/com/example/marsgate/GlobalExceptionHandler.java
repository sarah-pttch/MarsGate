package com.example.marsgate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TelTooLongException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleTelTooLongException(TelTooLongException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EssayTooLongException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String>
    handleEssayTooLongException(EssayTooLongException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
