package com.aumarbello.soflite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Contact contact = new Contact("Ahmed Umar", "aumarbello.com", "umar.bello@example.com");
    private static final ApiInfo apiInfo = new ApiInfo(
            "SOF-Lite",
            "SOF-Lite",
            "1.0",
            "urn:tos", contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>()
    );
    private static final Set<String> consumesAndProduces = new HashSet<>(Collections.singletonList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
                .produces(consumesAndProduces)
                .consumes(consumesAndProduces);
    }
}
