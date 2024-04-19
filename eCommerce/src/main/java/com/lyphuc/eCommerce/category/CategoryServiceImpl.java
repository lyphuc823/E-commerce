package com.lyphuc.eCommerce.category;

import com.lyphuc.eCommerce.category.CategoryRepository;
import com.lyphuc.eCommerce.category.CategoryDto;
import com.lyphuc.eCommerce.category.Category;
import com.lyphuc.eCommerce.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.category.CategoryMapper.mapToCategory;
import static com.lyphuc.eCommerce.category.CategoryMapper.mapToCategoryDto;


@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return getListCategoryDto(categories);
    }

    private List<CategoryDto> getListCategoryDto(List<Category> categories) {
        return categories.stream().map((category) -> mapToCategoryDto(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(int id) {
        Optional<Category> result = categoryRepository.findById(id);
        Category category = null;
        if(result.isPresent()){
            category = result.get();
        }else{
            throw new RuntimeException("Did not find category id: "+id);
        }
        return mapToCategoryDto(category);
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = mapToCategory(categoryDto);
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findFirst8Categories() {
        Page<Category> categories = categoryRepository.findAll(PageRequest.of(0,8));
        return categories;
    }

    @Override
    public Page<Category> findCategoriesAfterFirst8() {
        Page<Category> categories = categoryRepository.findAll(PageRequest.of(1,8));
        return categories;
    }


}
