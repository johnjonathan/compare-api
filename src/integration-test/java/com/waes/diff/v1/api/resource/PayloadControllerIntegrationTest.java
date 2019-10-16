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

import static com.waes.diff.v1.api.factory.PayloadFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.waes.diff.v1.api.domain.response.PayloadResponse;
import com.waes.diff.v1.api.repository.entity.Payload;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayloadControllerIntegrationTest {

  @Autowired private TestRestTemplate restTemplate;

  @Test
  public void putLeftPayload_ReturnsCreatedStatus() {
    HashMap<String, String> params = new HashMap<>();
    params.put("id", ID_1);
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/v1/diff/{id}}/left");
    HttpEntity<Payload> payloadEntity = new HttpEntity<>(leftPayload1());
    ResponseEntity<PayloadResponse> response =
        restTemplate.exchange(
            builder.buildAndExpand(params).toUri(),
            HttpMethod.PUT,
            payloadEntity,
            PayloadResponse.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }

  @Test
  public void putRightPayload_returnsCreatedStatus() {
    HashMap<String, String> params = new HashMap<>();
    params.put("id", ID_1);
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/v1/diff/{id}}/right");
    HttpEntity<Payload> payloadEntity = new HttpEntity<>(rightPayload1());
    ResponseEntity<PayloadResponse> response =
        restTemplate.exchange(
            builder.buildAndExpand(params).toUri(),
            HttpMethod.PUT,
            payloadEntity,
            PayloadResponse.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  }
}
