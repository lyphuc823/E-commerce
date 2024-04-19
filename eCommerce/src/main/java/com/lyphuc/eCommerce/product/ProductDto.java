package com.lyphuc.eCommerce.product;

import com.lyphuc.eCommerce.category.CategoryDto;
import com.lyphuc.eCommerce.productImage.ProductImage;
import com.lyphuc.eCommerce.productImage.ProductImageDto;
import com.lyphuc.eCommerce.provider.ProviderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private int productId;
    private String productName;
    private String description;
    private int price;
    private int stockQuantity;
    private String brand;
    private String overallRating;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private CategoryDto category;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "provider_id")
    private ProviderDto provider;
    @OneToMany(mappedBy = "product",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<ProductImageDto> productImages;
    public void addProductImage(ProductImageDto productImageDto){
        if(productImages == null){
            productImages = new ArrayList<>();
        }
        productImages.add(productImageDto);
    }
}
