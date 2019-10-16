/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.service;

import com.waes.diff.v1.api.domain.response.PayloadResponse;
import com.waes.diff.v1.api.repository.entity.Payload;
import com.waes.diff.v1.api.repository.entity.PayloadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayloadService {

  private final PayloadRepository payloadRepository;

  public PayloadResponse save(Payload payload) {
    Payload saved = payloadRepository.save(payload);
    return PayloadResponse.create()
        .status(HttpStatus.CREATED)
        .message(String.format("Payload [id:%s] created", saved.getId()));
  }
}
