package com.lyphuc.eCommerce.controller;

import com.lyphuc.eCommerce.comment.CommentDto;
import com.lyphuc.eCommerce.product.ProductDto;
import com.lyphuc.eCommerce.category.Category;
import com.lyphuc.eCommerce.category.CategoryService;
import com.lyphuc.eCommerce.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private ProductService productService;
    private CategoryService categoryService;
    @Autowired
    public HomeController(ProductService productService,CategoryService categoryService) {
        this.productService = productService;
        this.categoryService= categoryService;
    }
    @GetMapping("/")
    public String listProduct(Model model){
        List<ProductDto> products = productService.findAll();
        Page<Category> categoriesTop8 = categoryService.findFirst8Categories();
        Page<Category> categoriesFrom9 = categoryService.findCategoriesAfterFirst8();
        model.addAttribute("products",products);
        model.addAttribute("categoriesTop8",categoriesTop8);
        model.addAttribute("categoriesFrom9",categoriesFrom9);
        return "home";
    }
    @GetMapping("/product/{productId}")
    public String singleProduct(@PathVariable("productId") int id,Model model){
        ProductDto productDto = productService.findById(id);
        List<CommentDto> commentDtos = productService.getCommentsByProductId(id);
        model.addAttribute("product",productDto);
        model.addAttribute("comments",commentDtos);
        return "single-product";
    }
    @GetMapping("/product/modal/{productId}")
    public String singleProductModal(@PathVariable("productId") int id,Model model){
        ProductDto productDto = productService.findById(id);
        model.addAttribute("product",productDto);
        return "product-quick-view-modal";
    }
    @GetMapping("/product/list/{pageNo}")
    public String productList(@PathVariable("pageNo") int pageNo,
                              @RequestParam(value = "sortField", defaultValue = "productId") String sortField,
                              @RequestParam(value = "sortDir",defaultValue = "asc") String sortDir, Model model){
        int pageSize = 12;
        Page<ProductDto> page = productService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<ProductDto> productDtos = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());

        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("products",productDtos);
        return "shop-left-sidebar";

    }
    @GetMapping("/login")
    public String login(){
        return "login-register";
    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
