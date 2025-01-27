package com.acme.java_react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/messages")
    public List<String> getMessages() {
        return List.of("Hello, World!", "Welcome to the Spring Boot API", "Enjoy coding!");
    }

    @GetMapping("/users")
    public List<Map<String, String>> getUsers() {
        return List.of(
                Map.of("id", "1", "name", "Alice"),
                Map.of("id", "2", "name", "Bob"),
                Map.of("id", "3", "name", "Charlie")
        );
    }
}
