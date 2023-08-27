package com.example.fitssionbackend.product;

import com.example.fitssionbackend.product.dto.ProductDetailResponseDto;
import com.example.fitssionbackend.product.dto.ProductDto;
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

    public ProductDetailResponseDto getProductDetail(Long productId) {
        Product target = productRepository.findByIdJoinCategory(productId).get();
        List<ProductDto> relProducts = productRepository.findWithoutTargetId(productId)
                .stream().sorted(Comparator.comparingDouble((Product p) -> p.getCosineSimilarity(target)).reversed())
                .map(ProductDto::fromEntity)
                .limit(15)
                .toList();
        return ProductDetailResponseDto.from(target, relProducts);
    }
}
