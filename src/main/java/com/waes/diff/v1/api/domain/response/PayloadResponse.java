/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

/**
 * Payload Response
 */
@ApiModel(description = "Payload Response")
@Validated
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PayloadResponse {

  @JsonProperty("message")
  @ApiModelProperty("message")
  private String message;
  @JsonProperty("status")
  @ApiModelProperty("status")
  private HttpStatus status;

  public static PayloadResponse create() {
    return new PayloadResponse();
  }

  /**
   * Adds a description message
   *
   * @param message
   * @return The payload response
   */
  public PayloadResponse message(final String message) {
    this.message = message;
    return this;
  }

  /**
   * Adds a http status
   *
   * @param status
   * @return The payload response
   */
  public PayloadResponse status(final HttpStatus status) {
    this.status = status;
    return this;
  }
}
