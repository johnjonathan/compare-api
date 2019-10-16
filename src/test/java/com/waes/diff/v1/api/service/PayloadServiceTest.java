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

import static com.waes.diff.v1.api.factory.PayloadFactory.RIGHT_1;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.waes.diff.v1.api.domain.enums.Direction;
import com.waes.diff.v1.api.domain.response.PayloadResponse;
import com.waes.diff.v1.api.repository.entity.Payload;
import com.waes.diff.v1.api.repository.entity.PayloadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
@DataMongoTest
public class PayloadServiceTest {

  @Autowired private PayloadRepository payloadRepository;
  private PayloadService payloadService;

  @BeforeEach
  public void setUp() {
    payloadService = new PayloadService(payloadRepository);
  }

  @Test
  public void save() {
    PayloadResponse payloadResponse =
        payloadService.save(
            Payload.create().id("waes").direction(Direction.RIGHT).content(RIGHT_1));
    assertEquals("Payload [id:waes] created", payloadResponse.getMessage());
    assertEquals(HttpStatus.CREATED, payloadResponse.getStatus());
  }
}
