/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.domain.json;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * Request body object
 */
@ApiModel(description = "Request body object ")
@Validated
@Data
public class PayloadRequestBody {
  @JsonProperty("content")
  @ApiModelProperty("content")
  @NotBlank(message = "Content should not be null or empty")
  private String content;
}
