package com.lyphuc.eCommerce.category;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/list")
    public String listCategory(Model model){
        List<CategoryDto> categoryDtos = categoryService.findAll();
        model.addAttribute("categories",categoryDtos);
        return "admin/category-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        CategoryDto categoryDto = new CategoryDto();

        theModel.addAttribute("category", categoryDto);

        return "admin/category-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("categoryId") int theId,
                                    Model theModel) {

        CategoryDto categoryDto = categoryService.findById(theId);

        theModel.addAttribute("category", categoryDto);

        // send over to our form
        return "admin/category-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("category") @Valid CategoryDto categoryDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "admin/category-form";
        }
        categoryService.save(categoryDto);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/category/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("categoryId") int theId) {

        categoryService.deleteById(theId);

        return "redirect:/admin/category/list";

    }
}
