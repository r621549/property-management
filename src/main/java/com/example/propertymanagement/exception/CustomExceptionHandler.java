package com.example.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException){
        for(ErrorModel errorModel : businessException.getErrors()){
            logger.debug("Inside field validation {} - {}", errorModel.getCode(), errorModel.getMessage());
            logger.info("Inside field validation {} - {}", errorModel.getCode(), errorModel.getMessage());
            logger.warn("Inside field validation {} - {}", errorModel.getCode(), errorModel.getMessage());
            logger.error("Inside field validation {} - {}", errorModel.getCode(), errorModel.getMessage());

        }
        return new ResponseEntity<>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<ErrorModel> list = new ArrayList<>();
        List<FieldError> errors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
       for(FieldError fieldError : errors){
           logger.debug("Inside field validation {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
           logger.info("Inside field validation {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
           ErrorModel errorModel = new ErrorModel();
           errorModel.setCode(fieldError.getField());
           errorModel.setMessage(fieldError.getDefaultMessage());
           list.add(errorModel);
       }
        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
}
