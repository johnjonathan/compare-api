/*
 * Copyright 2015-2019 John Silva.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
