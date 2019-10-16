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
package com.waes.diff.v1.api.service;

import static com.waes.diff.v1.api.factory.PayloadFactory.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import com.waes.diff.v1.api.domain.enums.Result;
import com.waes.diff.v1.api.domain.model.PayloadDiffResult;
import com.waes.diff.v1.api.repository.entity.PayloadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PayloadDiffServiceTest {

  @Mock private PayloadRepository payloadRepository;
  private PayloadDiffService payloadDiffService;

  @BeforeEach
  public void setUp() throws Exception {
    payloadDiffService = new PayloadDiffService(payloadRepository);
  }

  @Test
  public void getDiff_shouldReturnEqual() {
    given(payloadRepository.findPayloadById(ID_1)).willReturn((listOfPayload()));
    PayloadDiffResult diffResult = payloadDiffService.getDiff(ID_1);
    assertEquals(Result.EQUAL, diffResult.getResult());
    assertThat(diffResult.getDetails().size()).isEqualTo(0);
  }

  @Test
  public void getDiff_shouldReturnThatSizeNotMatch() {
    given(payloadRepository.findPayloadById(ID_2)).willReturn((notEqualListOfPayload()));
    PayloadDiffResult diffResult = payloadDiffService.getDiff(ID_2);
    assertEquals(Result.SIZE_NOT_MATCH, diffResult.getResult());
    assertThat(diffResult.getDetails().size()).isEqualTo(0);
  }

  @Test
  public void getDiff_shouldReturnNotEqual_WithDetails() {
    given(payloadRepository.findPayloadById(ID_2)).willReturn((sameSizeNotEqualListOfPayload()));
    PayloadDiffResult diffResult = payloadDiffService.getDiff(ID_2);
    assertEquals(Result.NOT_EQUAL, diffResult.getResult());
    assertThat(diffResult.getDetails()).isNotEmpty();
  }
}
