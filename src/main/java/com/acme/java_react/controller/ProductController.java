package com.acme.java_react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<Map<String, Object>> getProducts() {
        return List.of(
                Map.of("id", 101, "name", "Laptop", "price", 1500),
                Map.of("id", 102, "name", "Smartphone", "price", 800),
                Map.of("id", 103, "name", "Tablet", "price", 600)
        );
    }
}
