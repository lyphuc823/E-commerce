package com.lyphuc.eCommerce.product;

import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.category.CategoryMapper.mapToCategory;
import static com.lyphuc.eCommerce.category.CategoryMapper.mapToCategoryDto;
import static com.lyphuc.eCommerce.productImage.ProductImageMapper.mapToProductImage;
import static com.lyphuc.eCommerce.productImage.ProductImageMapper.mapToProductImageDto;
import static com.lyphuc.eCommerce.provider.ProviderMapper.mapToProvider;
import static com.lyphuc.eCommerce.provider.ProviderMapper.mapToProviderDto;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        ProductDto productDto = ProductDto.builder()
                .productId(product.getProductId())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .productName(product.getProductName())
                .brand(product.getBrand())
                .overallRating(product.getOverallRating())
                .description(product.getDescription())
                .category(mapToCategoryDto(product.getCategory()))
                .provider(mapToProviderDto(product.getProvider()))
                .productImages(product.getProductImages().stream().map(productImage -> mapToProductImageDto(productImage)).collect(Collectors.toList()))
                .build();
        return productDto;
    }
    public static Product mapToProduct(ProductDto productDto){
        Product product = Product.builder()
                .productId(productDto.getProductId())
                .price(productDto.getPrice())
                .stockQuantity(productDto.getStockQuantity())
                .productName(productDto.getProductName())
                .brand(productDto.getBrand())
                .overallRating(productDto.getOverallRating())
                .description(productDto.getDescription())
                .category(mapToCategory(productDto.getCategory()))
                .provider(mapToProvider(productDto.getProvider()))
                .productImages(productDto.getProductImages().stream().map(productImageDto -> mapToProductImage(productImageDto)).collect(Collectors.toList()))
                .build();
        return product;
    }
}
