package com.bytelearn.gymapi.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrors {
  @Getter
  private List<String> errors;

  public ApiErrors(String message) {
    errors = Arrays.asList(message);
  }
}
