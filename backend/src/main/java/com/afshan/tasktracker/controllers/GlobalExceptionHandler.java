package com.afshan.tasktracker.controllers;

import com.afshan.tasktracker.domain.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    //“Whenever IllegalArgumentException occurs anywhere in controller flow, route it HERE.”
    @ExceptionHandler({IllegalArgumentException.class})
//RuntimeException → parent of IllegalArgumentException
//ex → actual thrown exception
//request → current HTTP request
//Used for metadata (URI)
//    HttpStatus.BAD_REQUEST → enum constant
//.value() → returns 400
//    getMessage() → text passed during throw
//    false → don’t include session ID
//returns string like: uri=/tasks
    public ResponseEntity<ErrorResponse> handleExceptions(
            RuntimeException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);

    }
}

/*
Service throws IllegalArgumentException
 → Spring intercepts
 → GlobalExceptionHandler runs
 → ErrorResponse created
 → ResponseEntity returned
 → Client receives structured JSON error
*/