/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseError {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime timestamp = LocalDateTime.now();

  private Integer status;
  private String message;

  public static ResponseError create() {
    return new ResponseError();
  }

  public ResponseError message(String message) {
    this.message = message;
    return this;
  }

  public ResponseError status(HttpStatus status) {
    this.status = status.value();
    return this;
  }
}
