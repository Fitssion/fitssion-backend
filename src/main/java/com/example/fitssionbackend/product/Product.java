package com.example.fitssionbackend.product;

import com.example.fitssionbackend.BaseTimeEntity;
import com.example.fitssionbackend.category.Category;
import com.example.fitssionbackend.util.CosineSimilarity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String seller;

    private String link;

    private String imgSrc;

    private Integer gender; // 0 : 공용, 1 : 남, 2 : 여

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public double getCosineSimilarity(Product target) {
        double[] targetVector = target.getCategory().getCategoryVector();
        double[] curVector = this.getCategory().getCategoryVector();
        return CosineSimilarity.cosineSimilarity(targetVector, curVector);
    }
}
