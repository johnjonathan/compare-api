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

import com.waes.diff.v1.api.exception.error.ResponseError;
import org.springframework.http.HttpStatus;

public interface PayloadResponseError {

  String getMessage();

  default ResponseError getResponseError() {
    return ResponseError.create().message(getMessage()).status(HttpStatus.BAD_REQUEST);
  }
}
