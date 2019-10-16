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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.waes.diff.v1.api.domain.response.PayloadResponse;
import com.waes.diff.v1.api.repository.entity.Payload;
import com.waes.diff.v1.api.service.PayloadService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(PayloadController.class)
public class PayloadControllerTest {

  @Autowired MockMvc mockMvc;
  @MockBean private PayloadService payloadService;

  @Test
  public void whenPutLeftPayload_addPayloadToComparation() throws Exception {
    final String content = "{\"content\":\"Y29tcGFyYXRpb24gc2l6ZQ==\"}";
    given(payloadService.save(any(Payload.class)))
        .willReturn(PayloadResponse.create().message("created"));
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/v1/diff/{id}/left", "001")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.message", Is.is("created")))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    verify(payloadService).save(any(Payload.class));
  }

  @Test
  public void whenPutRightPayload_addPayloadToComparation() throws Exception {
    final String content = "{\"content\":\"Y29tcGFyYXRpb24gc2l6ZQ==\"}";
    given(payloadService.save(any(Payload.class)))
        .willReturn(PayloadResponse.create().message("created"));
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/v1/diff/{id}/right", "002")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.message", Is.is("created")))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    verify(payloadService).save(any(Payload.class));
  }

  @Test
  public void whenPutLeftPayloadWithInvalidBody_returnNotFound() throws Exception {
    final String content = "{\"content\":\"\"}";
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/v1/diff/{id}/left", "003")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.content", Is.is("Content should not be null or empty")));
  }

  @Test
  public void whenPutRightPayloadWithInvalidBody_returnNotFound() throws Exception {
    final String content = "{\"content\":\"\"}";
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/v1/diff/{id}/right", "004")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.content", Is.is("Content should not be null or empty")));
  }
}
