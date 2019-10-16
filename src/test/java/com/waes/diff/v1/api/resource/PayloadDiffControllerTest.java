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

import com.waes.diff.v1.api.domain.enums.Result;
import com.waes.diff.v1.api.domain.model.PayloadDiffResult;
import com.waes.diff.v1.api.service.PayloadDiffService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PayloadDiffController.class)
public class PayloadDiffControllerTest {

  @Autowired MockMvc mockMvc;
  @MockBean
  PayloadDiffService payloadDiffService;

  @Test
  public void getPayloadDiff_shouldReturnEqual() throws Exception {
    given(payloadDiffService.getDiff("001")).willReturn(PayloadDiffResult.create().result(Result.EQUAL));
    mockMvc
        .perform(get("/v1/diff/{id}", "001"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").isNotEmpty());
  }
}
