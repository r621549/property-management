package com.example.propertymanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors){
        this.errors = errors;
    }
}
