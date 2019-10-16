/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.exception;

import com.waes.diff.v1.api.exception.error.ResponseError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@ControllerAdvice
@RestControllerAdvice
public class PayloadGlobalControllerAdvisor {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DuplicateKeyException.class)
  public ResponseError handleDuplicatedKey() {
    return ResponseError.create()
        .status(HttpStatus.BAD_REQUEST)
        .message("The load you are trying to add has already been added previously.");
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseError handleNotFound(Exception ex) {
    return ResponseError.create().status(HttpStatus.NOT_FOUND).message(ex.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            error -> {
              String fieldName = ((FieldError) error).getField();
              String errorMessage = error.getDefaultMessage();
              errors.put(fieldName, errorMessage);
            });
    return errors;
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public void constraintViolationException(HttpServletResponse response) throws IOException {
    response.sendError(HttpStatus.BAD_REQUEST.value());
  }
}
