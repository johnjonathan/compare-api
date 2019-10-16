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

import com.waes.diff.v1.api.domain.enums.Result;
import com.waes.diff.v1.api.domain.model.PayloadDiffResult;
import com.waes.diff.v1.api.repository.entity.PayloadRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.waes.diff.v1.api.factory.PayloadFactory.*;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
public class PayloadDiffServiceTest {

  @Mock
  private PayloadRepository payloadRepository;
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
