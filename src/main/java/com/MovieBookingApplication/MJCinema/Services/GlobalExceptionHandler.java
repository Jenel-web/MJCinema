package com.MovieBookingApplication.MJCinema.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //for error checking.
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex){
        //the argument is the message displayed in the code when you throw runtime exception.

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now()); //request time
        body.put("message", ex.getMessage()); //argument
        body.put("status", HttpStatus.BAD_REQUEST.value());//error code

        return new  ResponseEntity<> (body, HttpStatus.BAD_REQUEST);
    }

}
