package com.lyphuc.eCommerce.productImage;


import com.lyphuc.eCommerce.productImage.ProductImageDto;

import java.util.List;

public interface ProductImageService {
    List<ProductImageDto> findAll();
    ProductImageDto findById(int id);
    void save(int productId, ProductImageDto productImageDto);
    void deleteById(int id);
}
