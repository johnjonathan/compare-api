/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.resource;

import com.waes.diff.v1.api.domain.enums.Direction;
import com.waes.diff.v1.api.domain.json.PayloadRequestBody;
import com.waes.diff.v1.api.domain.response.PayloadResponse;
import com.waes.diff.v1.api.repository.entity.Payload;
import com.waes.diff.v1.api.service.PayloadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/v1/diff")
@RequiredArgsConstructor
@Api(value = "v1", tags = "payloads")
public class PayloadController implements PayloadApi{

  private final PayloadService payloadService;
  /**
   * Creates a {@code Payload} register on the database to be compared later.
   *
   * @param id Path parameter
   * @param body JSON Object from body request
   * @param direction The side to used in the comparison
   * @return {@code PayloadResponse} with a message and a status code.
   */
  private PayloadResponse save(String id, PayloadRequestBody body, Direction direction) {
    return payloadService.save(
        Payload.create().id(id).content(body.getContent()).direction(direction));
  }

  @Override
  public ResponseEntity<PayloadResponse> addLeftPayload(@ApiParam(value = "id",required=true) @PathVariable("id") String id,@ApiParam(value = "requestBody" ,required=true )  @Valid @RequestBody PayloadRequestBody requestBody) {
    return ResponseEntity.status(HttpStatus.CREATED).body(save(id, requestBody, Direction.LEFT));
  }

  @Override
  public ResponseEntity<PayloadResponse> addRightPayload(@ApiParam(value = "id",required=true) @PathVariable("id") String id,@ApiParam(value = "requestBody" ,required=true )  @Valid @RequestBody PayloadRequestBody requestBody) {
    return ResponseEntity.status(HttpStatus.CREATED).body(save(id, requestBody, Direction.RIGHT));
  }
}
