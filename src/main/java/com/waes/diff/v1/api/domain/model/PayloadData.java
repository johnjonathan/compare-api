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

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PayloadData {
  @JsonIgnore private String id;

  @JsonProperty("LEFT")
  @NotBlank(message = "LEFT side must be not null")
  private String left;

  @JsonProperty("RIGHT")
  @NotBlank(message = "RIGHT side must be not null")
  private String right;

  public boolean isEqual() {
    return left.equals(right);
  }

  public boolean sizeDosNotMatch() {
    return length(left) != length(right);
  }

  public boolean isNoneBlank() {
    return isNotBlank(left) && isNotBlank(right);
  }
}
