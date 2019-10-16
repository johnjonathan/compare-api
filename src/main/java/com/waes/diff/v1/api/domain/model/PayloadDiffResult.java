/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.waes.diff.v1.api.domain.enums.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Holds the comparison result
 *  - EQUAL
 *  - NOT_EQUAL
 *  - SIZE_NOT_MATCH
 */
@ApiModel(description = "Holds the comparison result   - EQUAL  - NOT_EQUAL  - SIZE_NOT_MATCH  ")
@Validated
@Data
public class PayloadDiffResult {
  @JsonProperty("result")
  @ApiModelProperty("result")
  private Result result;
  @Valid
  @JsonProperty("details")
  @ApiModelProperty("details")
  private List<DiffDetails> details;

  private PayloadDiffResult() {
    details = Optional.ofNullable(details).orElse(new LinkedList<>());
  }

  public static PayloadDiffResult create() {
    return new PayloadDiffResult();
  }

  /**
   * Payload's result data
   * @param result
   * @return current object instance
   */
  public PayloadDiffResult result(Result result) {
    this.result = result;
    return this;
  }

  /**
   * Adds a list of details
   * @param details
   * @return current object instance
   */
  public PayloadDiffResult addDetails(List<DiffDetails> details) {
    this.details.addAll(details);
    return this;
  }

}
