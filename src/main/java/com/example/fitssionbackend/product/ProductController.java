package com.example.fitssionbackend.product;

import com.example.fitssionbackend.product.dto.ProductDetailResponseDto;
import com.example.fitssionbackend.product.dto.ProductListDto;
import com.example.fitssionbackend.product.dto.ProductRequest;
import com.example.fitssionbackend.product.dto.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ProductListDto> getProductList(@ProductRequest ProductRequestDto request) {
        return ResponseEntity.ok(productService.getProductList(request));
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDetailResponseDto> getProductDetail(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductDetail(productId));
    }
}
