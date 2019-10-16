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

import com.waes.diff.v1.api.domain.model.PayloadDiffResult;
import com.waes.diff.v1.api.service.PayloadDiffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/diff")
@Api(value = "v1", tags = "payloads")
public class PayloadDiffController implements PayloadDiffApi{

  private final PayloadDiffService payloadDiffService;

  public ResponseEntity<PayloadDiffResult> getPayloadDifferences(@PathVariable("id") @NotBlank String id) {
    return ResponseEntity.ok(payloadDiffService.getDiff(id));
  }
}
