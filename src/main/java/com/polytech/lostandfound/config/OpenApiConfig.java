package com.polytech.lostandfound.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI lostAndFoundOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Lost & Found API")
                        .version("0.0.1")
                        .description("REST API for reporting and searching lost and found items."));
    }
}
