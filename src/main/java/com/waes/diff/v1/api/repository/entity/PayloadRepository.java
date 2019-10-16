/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.repository.entity;

import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayloadRepository extends MongoRepository<Payload, String> {

  List<Payload> findPayloadById(@NotBlank String id);
}
