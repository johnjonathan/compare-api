/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.factory;

import static com.waes.diff.v1.api.repository.entity.Payload.create;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waes.diff.v1.api.domain.enums.Direction;
import com.waes.diff.v1.api.repository.entity.Payload;
import java.util.List;
import org.assertj.core.util.Lists;

public class PayloadFactory {

  public static final String LEFT_1 =
      "IHsKICAgIm5hbWUiOiJXYWVzIiwKICAgImNvdW50cnkiOiJOZXRoZXJsYW5kcyIKIH0K";
  public static final String RIGHT_1 =
      "IHsKICAgIm5hbWUiOiJXYWVzIiwKICAgImNvdW50cnkiOiJOZXRoZXJsYW5kcyIKIH0K";
  public static final String LEFT_2 =
      "IHsKICAgIm5hbWUiOiIxQnl0ZSIsCiAgICJjb3VudHJ5IjoiQnJhemlsIgogfQo=";
  public static final String RIGHT_2 =
      "IHsKICAgIm5hbWUiOiIxQnl0ZSIsCiAgICJjb3VudHJ5IjoiQnJhemlsIgogfQo=";
  public static final String ID_1 = "id_1";
  public static final String ID_2 = "id_2";
  public static final String INVALID_CONTENT = "{\"content\" : \"\"}";
  public static final String LEFT_3 = "Y29tcGFyYXRpb24gc2l6ZQ==";
  public static final String RIGHT_3 = "a29tcGFyYXRpb24gc2l0ZQ==";

  public static Payload leftPayload1() {
    return Payload.create().content(LEFT_1).direction(Direction.LEFT).id(ID_1);
  }

  public static Payload rightPayload1() {
    return create().content(RIGHT_1).direction(Direction.RIGHT).id(ID_1);
  }

  public static Payload leftPayload2() {
    return create().content(LEFT_2).direction(Direction.LEFT).id(ID_2);
  }

  public static Payload rightPayload2() {
    return create().content(RIGHT_2).direction(Direction.RIGHT).id(ID_2);
  }

  public static Payload leftPayload3() {
    return create().content(LEFT_3).direction(Direction.LEFT).id(ID_2);
  }

  public static Payload rightPayload3() {
    return create().content(RIGHT_3).direction(Direction.RIGHT).id(ID_2);
  }

  public static List<Payload> listOfPayload() {
    return Lists.newArrayList(leftPayload1(), rightPayload1());
  }

  public static List<Payload> sameSizeNotEqualListOfPayload() {
    return Lists.newArrayList(leftPayload3(), rightPayload3());
  }

  public static List<Payload> notEqualListOfPayload() {
    return Lists.newArrayList(leftPayload1(), rightPayload2());
  }

  public static String payloadContent(Payload payload) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(payload);
  }
}
