package com.lyphuc.eCommerce.category;

import com.lyphuc.eCommerce.category.CategoryDto;
import com.lyphuc.eCommerce.category.Category;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category) {
        CategoryDto categoryDto = CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
//        categoryDto.setProducts();
        return categoryDto;
    }
    public static Category mapToCategory(CategoryDto categoryDto) {
        Category category = Category.builder()
                .categoryId(categoryDto.getCategoryId())
                .categoryName(categoryDto.getCategoryName())
                .build();
//        categoryDto.setProducts();
        return category;
    }
}
