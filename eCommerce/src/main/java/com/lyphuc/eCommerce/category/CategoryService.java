package com.lyphuc.eCommerce.category;

import com.lyphuc.eCommerce.category.CategoryDto;
import com.lyphuc.eCommerce.category.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(int id);
    void save(CategoryDto categoryDto);
    void deleteById(int id);
    Page<Category> findFirst8Categories();
    Page<Category> findCategoriesAfterFirst8();
}
