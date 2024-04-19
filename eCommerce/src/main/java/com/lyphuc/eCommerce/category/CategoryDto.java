package com.lyphuc.eCommerce.category;

import com.lyphuc.eCommerce.product.Product;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private int categoryId;
    @NotEmpty(message = "Category name should not be empty")
    private String categoryName;
    private List<Product> products;

}
