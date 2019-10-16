/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.domain.exception;

import java.text.MessageFormat;

public class PayloadForComparisonNotFound extends RuntimeException implements PayloadResponseError {
  public PayloadForComparisonNotFound(String id) {
    super(MessageFormat.format("Requested Id [{0}] not found for comparasion.", id));
  }

  public PayloadForComparisonNotFound() {
    super("No content found for comparison.");
  }
}
