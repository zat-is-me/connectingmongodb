package com.segnut.conectingmongodb.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "Default Error";

    //----------- localhost:8080/api/v1/message/r -------------
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Invalid Value passed! ", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    //------------ localhost:8080/api/v1/message/9999 -------
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "No value present! ", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    //---------- localhost:8080/api/v1/message/ --------------
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<Object> handleNoResourceFoundException(
            Exception ex, WebRequest request) {

//-------- custom class -------------
//        ResponseBean response = new ResponseBean();
//        response.setResponseCode(ResponseConstants.ResponseCodes.ERROR_URL.getCode());
//        response.setMessage(ResponseConstants.ResponseCodes.ERROR_URL.getMessage());

        return new ResponseEntity<Object>(
                "Bad Request", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
