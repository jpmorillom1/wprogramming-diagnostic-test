package com.uce.jp.diagnostic_test_backend.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.xml.transform.sax.SAXResult;

@RestControllerAdvice
public class RestExceptionHander {



    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<?> handleException(HttpClientErrorException ex){
        String error= ex.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleException(MethodArgumentTypeMismatchException ex){
        String error= ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
