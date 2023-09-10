package com.example.fitssionbackend.product;

import com.example.fitssionbackend.product.dto.ProductDetailResponseDto;
import com.example.fitssionbackend.product.dto.ProductDto;
import com.example.fitssionbackend.product.dto.ProductListDto;
import com.example.fitssionbackend.product.dto.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    public static final int MAX_SIZE = 15;

    public ProductDetailResponseDto getProductDetail(Long productId) {
        Product target = productRepository.findByIdJoinCategory(productId).get();
        List<ProductDto> relProducts = productRepository.findWithoutTargetId(productId)
                .stream().sorted(Comparator.comparingDouble((Product p) -> p.getCosineSimilarity(target)).reversed())
                .map(ProductDto::fromEntity)
                .limit(MAX_SIZE)
                .toList();
        return ProductDetailResponseDto.from(target, relProducts);
    }

    public ProductListDto getProductList(ProductRequestDto request) {
        List<ProductDto> productList = productRepository.findByGender(request.getGender()).stream()
                .sorted(Comparator.comparingDouble((Product p) -> p.getCosineSimilarity(request.getCategory())).reversed())
                .map(ProductDto::fromEntity)
                .skip((long) MAX_SIZE * request.getPage())
                .limit(MAX_SIZE)
                .toList();
        return new ProductListDto(productList);

    }
}
