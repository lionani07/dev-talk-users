package com.github.lionani07.appussers.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(Exception e) {
        return ResponseEntity.internalServerError().body(e.toString());
    }

}
