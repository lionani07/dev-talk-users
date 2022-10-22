package com.github.lionani07.appussers.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class HandlerError {
    private HttpStatus status;
    private String message;
}
