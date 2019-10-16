package com.waes.diff.v1.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(IndexController.class)
class IndexControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	void index_redirectToSwagger() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("swagger-ui.html"));
	}
}