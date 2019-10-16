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

import com.waes.diff.v1.api.domain.model.DiffDetails;
import com.waes.diff.v1.api.domain.model.PayloadData;
import com.waes.diff.v1.api.domain.model.PayloadDiffResult;
import java.util.LinkedList;

public interface DiffService {

  PayloadDiffResult getDiff(String id);

  PayloadDiffResult compareSides(PayloadData payloadData);

  LinkedList<DiffDetails> getDiffDetails(PayloadData payloadData);
}
