package com.example.fitssionbackend.product.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ProductRequestDto {
    private List<Integer> category;
    private Integer gender;
    private Integer sort;
    private Integer page;
}
