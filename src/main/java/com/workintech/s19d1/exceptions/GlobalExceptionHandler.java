package com.workintech.s19d1.exceptions;

/*
Interceptor - Hatalarda Araya Girer
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler // Otomatik algılamazsa bunu ekle (ApiException.class)
    public ResponseEntity<ExceptionResponse> handleException(ApiException theException) {
        ExceptionResponse errorResponse = new ExceptionResponse();
        errorResponse.setStatus(theException.getHttpStatus().value());
        errorResponse.setMessage(theException.getMessage());
        errorResponse.setDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, theException.getHttpStatus());
    }

    // Bu Global Hata Yakalama Kısmı, gelen hatayı INTERNAL_SERVER_ERROR olarak ayarlar.
    @ExceptionHandler // Otomatik algılamazsa bunu ekle (Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception theException) {
        ExceptionResponse errorResponse = new ExceptionResponse();

        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage(theException.getMessage());
        errorResponse.setDateTime(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
