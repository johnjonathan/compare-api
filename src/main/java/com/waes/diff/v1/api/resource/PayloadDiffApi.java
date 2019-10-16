package com.waes.diff.v1.api.resource;

import com.waes.diff.v1.api.domain.model.PayloadDiffResult;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Api(value = "v1")
public interface PayloadDiffApi {
	@ApiOperation(value = "Comparison REST Endpoint",
	nickname = "getPayloadDifferences",
	response = PayloadDiffResult.class,
	tags = {"payloads"})
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PayloadDiffResult.class),
	@ApiResponse(code = 404, message = "Not found")})
	@GetMapping (value = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<PayloadDiffResult> getPayloadDifferences(@ApiParam(value = "id", required = true)
	@PathVariable("id") String id);
}
