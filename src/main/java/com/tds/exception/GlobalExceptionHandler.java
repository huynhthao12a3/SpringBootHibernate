package com.tds.exception;

import com.tds.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Bắt Exception khi Runtime
     * */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    /*
     * Bắt Exception, validation trong DTO
     * */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseObject<ResponseEntity> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ResponseEntity<String> message =  ResponseEntity.badRequest().body(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
        return new ResponseObject<ResponseEntity>(false,"Fail",message.getBody(),null);
    }

}
