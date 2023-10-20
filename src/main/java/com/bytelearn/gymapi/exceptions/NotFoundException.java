package com.bytelearn.gymapi.exceptions;

public class NotFoundException extends BusinessRuleException {
  
  public NotFoundException() {
    super("Resource not found.");
  }
}
