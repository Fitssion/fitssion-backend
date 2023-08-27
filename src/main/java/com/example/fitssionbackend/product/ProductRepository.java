package com.example.fitssionbackend.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join fetch p.category c where p.id <> :productId")
    List<Product> findWithoutTargetId(Long productId);

    @Query("select p from Product p join fetch p.category c where p.id = :productId")
    Optional<Product> findByIdJoinCategory(Long productId);
}
