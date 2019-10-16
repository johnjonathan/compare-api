/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.repository.entity;

import static lombok.AccessLevel.PRIVATE;

import com.waes.diff.v1.api.domain.enums.Direction;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "payloads")
@CompoundIndex(def = "{'id': 1, 'direction': 1, 'content': 1 }", unique = true)
@NoArgsConstructor(access = PRIVATE)
public class Payload {
  @Id private String uid;

  @NotBlank(message = "Id is mandatory")
  @Field
  private String id;

  @NotBlank(message = "ID can not be null or empty")
  @Field
  private Direction direction;

  @NotBlank(message = "Content is mandatory")
  @Field
  private String content;

  public static Payload create() {
    return new Payload();
  }

  public Payload id(String id) {
    this.id = id;
    return this;
  }

  public Payload direction(Direction direction) {
    this.direction = direction;
    return this;
  }

  public Payload content(String content) {
    this.content = content;
    return this;
  }
}
