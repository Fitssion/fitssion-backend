package com.example.fitssionbackend.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ProductController {

    @GetMapping
    public ProductRequestDto getProductList(@ProductRequest ProductRequestDto request) {
        return request;
    }
}
