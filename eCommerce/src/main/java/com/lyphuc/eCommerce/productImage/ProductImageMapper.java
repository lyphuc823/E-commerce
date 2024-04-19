package com.lyphuc.eCommerce.productImage;

import com.lyphuc.eCommerce.productImage.ProductImageDto;
import com.lyphuc.eCommerce.productImage.ProductImage;

public class ProductImageMapper {
    public static ProductImageDto mapToProductImageDto(ProductImage productImage){
        ProductImageDto productImageDto = ProductImageDto.builder()
                .imageId(productImage.getImageId())
                .imageUrl(productImage.getImageUrl())
                .isPrimary(productImage.getIsPrimary())
                .build();
        return productImageDto;
    }
    public static ProductImage mapToProductImage(ProductImageDto productImageDto){
        ProductImage productImage = ProductImage.builder()
                .imageId(productImageDto.getImageId())
                .imageUrl(productImageDto.getImageUrl())
                .isPrimary(productImageDto.getIsPrimary())
                .build();
        return productImage;
    }
}
