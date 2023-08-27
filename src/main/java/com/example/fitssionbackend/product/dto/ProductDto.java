package com.example.fitssionbackend.product.dto;

import com.example.fitssionbackend.product.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private String seller;
    private Integer price;
    private List<String> categoryId;
    private String imgSrc;
    private String gender;
    private String link;

    public static ProductDto fromEntity(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .seller(product.getSeller())
                .price(product.getPrice())
                .categoryId(product.getCategory().getCategoryId())
                .imgSrc(product.getImgSrc())
                .gender(product.getGender() == 0 ? "남여공용" : product.getGender() == 1 ? "남" : "여")
                .link(product.getLink())
                .build();
    }
}
