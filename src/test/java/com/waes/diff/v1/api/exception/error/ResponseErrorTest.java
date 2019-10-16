package com.waes.diff.v1.api.exception.error;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResponseErrorTest {

	@Test void create_responseErrorWithStatusAndMessage() {
		LocalDateTime dateTime = LocalDateTime.now();
		ResponseError error = ResponseError.create()
				.message("Lorem ipsum dolor sit amet")
				.status(HttpStatus.ACCEPTED);
		error.setTimestamp(dateTime);
		assertNotNull(error);
		assertThat(error.getMessage(), is(equalTo("Lorem ipsum dolor sit amet")));
		assertThat(error.getStatus(), is(equalTo(HttpStatus.ACCEPTED.value())));
		assertThat(error.getTimestamp(), is(equalTo(dateTime)));
	}
}