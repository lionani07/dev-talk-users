package com.github.lionani07.appussers.handler;

import com.github.lionani07.appussers.exceptions.AppVideosComunicationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(Exception e) {
        return ResponseEntity.internalServerError().body(e.toString());
    }

    @ExceptionHandler(AppVideosComunicationException.class)
    public ResponseEntity<?> handler(AppVideosComunicationException e) {
        final HandlerError handlerError = new HandlerError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerError);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handler(EmptyResultDataAccessException e) {
        final HandlerError handlerError = new HandlerError(HttpStatus.NOT_FOUND, "Recurso nao encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(handlerError);
    }

}
