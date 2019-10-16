/*
 * Copyright 2015-2019 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */
package com.waes.diff.v1.api.swagger.config;

import com.fasterxml.classmate.TypeResolver;
import com.waes.diff.v1.api.resource.PayloadController;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(SWAGGER_2)
            .useDefaultResponseMessages(false)
            .groupName("tech-assignment")
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(not(PathSelectors.regex("/error.*")))
//            .paths(PathSelectors.any())
            .build();
  }

//  Docket apiV1()

  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Encoded JSON Diff Comparison")
            .description("This is a simple server encoded JSON comparator.")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("John Silva","", "johnjonathann@live.com"))
            .build();
  }

}
