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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@ApiModel(description = "Holds the length and offset of differences")
@Validated
public class DiffDetails {

  @JsonProperty("offset")
  @ApiModelProperty("offset")
  private Integer offset;
  @JsonProperty("length")
  @ApiModelProperty("length")
  private Integer length;
}
