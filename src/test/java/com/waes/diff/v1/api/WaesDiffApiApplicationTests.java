/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api;

import com.waes.diff.v1.api.controller.IndexController;
import com.waes.diff.v1.api.resource.PayloadController;
import com.waes.diff.v1.api.resource.PayloadDiffController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaesDiffApiApplicationTests {

  @Autowired
  PayloadController payloadController;
  @Autowired
  PayloadDiffController payloadDiffController;
  @Autowired
  IndexController indexController;

  @Test
  public void contextLoads() {
    assertThat(payloadController).isNotNull();
    assertThat(payloadDiffController).isNotNull();
    assertThat(indexController).isNotNull();
  }
}
