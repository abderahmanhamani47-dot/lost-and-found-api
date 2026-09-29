package com.polytech.lostandfound.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "name", "Lost & Found API",
                "description", "REST API for reporting and searching lost and found items.",
                "features", new String[]{"Create, read, update and delete items", "Validation", "OpenAPI / Swagger", "Spring Security foundation"},
                "howToRun", "mvn spring-boot:run",
                "swagger", "/swagger-ui.html",
                "apiDocs", "/v3/api-docs",
                "developers", "Polytech Nancy - Génie logiciel project"
        );
    }
}
