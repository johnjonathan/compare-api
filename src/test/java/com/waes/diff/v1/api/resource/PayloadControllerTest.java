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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(PayloadController.class)
public class PayloadControllerTest {

  @Autowired MockMvc mockMvc;
  @MockBean private PayloadService payloadService;

  @Test
  public void whenAddLeftPayload_addPayloadToComparation() throws Exception {
    final String content = "{\"content\":\"Y29tcGFyYXRpb24gc2l6ZQ==\"}";
    given(payloadService.save(any(Payload.class)))
        .willReturn(PayloadResponse.create().message("created"));
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/v1/diff/{id}/left", "001")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.message", Is.is("created")))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    verify(payloadService).save(any(Payload.class));
  }

  @Test
  public void whenAddRightPayload_addPayloadToComparation() throws Exception {
    final String content = "{\"content\":\"Y29tcGFyYXRpb24gc2l6ZQ==\"}";
    given(payloadService.save(any(Payload.class)))
        .willReturn(PayloadResponse.create().message("created"));
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/v1/diff/{id}/right", "002")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.message", Is.is("created")))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    verify(payloadService).save(any(Payload.class));
  }

  @Test
  public void whenAddLeftPayloadWithInvalidBody_returnNotFound() throws Exception {
    final String content = "{\"content\":\"\"}";
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/v1/diff/{id}/left", "003")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.content", Is.is("Content should not be null or empty")));
  }

  @Test
  public void whenAddRightPayloadWithInvalidBody_returnNotFound() throws Exception {
    final String content = "{\"content\":\"\"}";
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/v1/diff/{id}/right", "004")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.content", Is.is("Content should not be null or empty")));
  }
}
