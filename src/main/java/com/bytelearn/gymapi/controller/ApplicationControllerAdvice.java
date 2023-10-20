package com.bytelearn.gymapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bytelearn.gymapi.exceptions.ApiErrors;
import com.bytelearn.gymapi.exceptions.BusinessRuleException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {
  
  @ExceptionHandler(BusinessRuleException.class)
  public ApiErrors handleBusinessRuleException(BusinessRuleException ex) {
    return new ApiErrors(ex.getMessage());
  }
}
