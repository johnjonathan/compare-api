package com.waes.diff.v1.api.resource;

import com.waes.diff.v1.api.domain.json.PayloadRequestBody;
import com.waes.diff.v1.api.domain.response.PayloadResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(value = "v1")
public interface PayloadApi {
	@ApiOperation(value = "Add a new registry to be compared as **left** side.", nickname = "addLeftPayload", response = PayloadResponse.class, tags = {
	"payloads",}) @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PayloadResponse.class),
	@ApiResponse(code = 201, message = "Payload create", response = PayloadResponse.class),
	@ApiResponse(code = 400, message = "Invalid payload")})
	@PostMapping(value = "/{id}/left", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<PayloadResponse> addLeftPayload(
	@ApiParam(value = "id", required = true) @PathVariable("id") String id,
	@ApiParam(value = "requestBody", required = true) @Valid @RequestBody PayloadRequestBody requestBody);

	@ApiOperation(value = "Add a new registry to be compared as **right** side.", nickname = "addRightPayload", response = PayloadResponse.class, tags = {
	"payloads",}) @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = PayloadResponse.class),
	@ApiResponse(code = 201, message = "Payload create", response = PayloadResponse.class),
	@ApiResponse(code = 400, message = "Invalid payload")})
	@PostMapping(value = "/{id}/right", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<PayloadResponse> addRightPayload(@ApiParam(value = "id",required=true) @PathVariable("id") String id,@ApiParam(value = "requestBody" ,required=true )  @Valid @RequestBody PayloadRequestBody requestBody);
}
