package com.lyphuc.eCommerce.productImage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {
    List<ProductImage> findByProductProductId(int id);
}
