/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicabeans.api.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author medineshkatwal
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //                .apis(RequestHandlerSelectors.any()) // show all service, including spring-boot default.
                .apis(RequestHandlerSelectors.basePackage("com.logicabeans.api.crud.controller")) // show specific class path only
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "User Crud Api",
                "Documentation of Project User Crud API",
                "1.0",
                "Terms of service",
                new Contact("Dinesh Katwal", "https://k2glyph.github.io", "medineshkatwal@gmail.com"), // author
                "Open Source", "Open Source Any one is allow to modified and distribute");
    }

}
