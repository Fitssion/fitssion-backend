package com.example.fitssionbackend.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProductListDto {
    private List<ProductDto> data;
}
