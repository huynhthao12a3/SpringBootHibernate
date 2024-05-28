package com.tds.exception;

import com.tds.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseObject<Object> handleRuntimeException(RuntimeException e) {
        ResponseEntity<String> message = ResponseEntity.badRequest().body(e.getMessage());
        return new ResponseObject<>(false, "Fail", message.getBody(), null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseObject<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ResponseEntity<String> message = ResponseEntity.badRequest().body(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
        return new ResponseObject<>(false, "Fail", message.getBody(), null);
    }

}
