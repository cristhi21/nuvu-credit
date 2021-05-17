package com.nuvucreditcvargas.nuvucredit.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nuvucreditcvargas.nuvucredit.web.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
            "Nuvu credit API",
            "Esta api muestra personas y sus tarjetas de credito",
            "1.0",
            "Terminos y condiciones",
            new Contact("Cristhian Vargas", "www.cvargas.com","cristhian.avc21@gmail.com"),
            "License of API",
            "API license URL",
            Collections.emptyList()
        );
    }
}
