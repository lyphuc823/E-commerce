package com.lyphuc.eCommerce.product;

import com.lyphuc.eCommerce.productImage.ProductImage;
import com.lyphuc.eCommerce.productImage.ProductImageDto;
import com.lyphuc.eCommerce.productImage.ProductImageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    private ProductService productService;
    private ProductImageService productImageService;

    public ProductController(ProductService productService, ProductImageService productImageService) {
        this.productService = productService;
        this.productImageService = productImageService;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<ProductDto> productDtos = productService.findAll();
        model.addAttribute("products",productDtos);
        return "admin/product-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("product",productDto);
        return "admin/product-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int id, Model model){
        ProductDto productDto = productService.findById(id);
        model.addAttribute("product",productDto);
        return "admin/product-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product")@Valid ProductDto productDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/product-form";
        }
        productService.save(productDto);
        return "redirect:/admin/product/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int id){
        productService.deleteById(id);
        return "redirect:/admin/product/list";
    }

    /////////////
    @GetMapping("/image/{productId}")
    public String getListImages(@PathVariable("productId")int productId, Model model){
        List<ProductImageDto> productImageDtos =productService.getProductImagesByProductId(productId);
        model.addAttribute("productImages",productImageDtos);
        return "admin/product-image-list";
    }
    @GetMapping("/image/showFormForAdd/{productId}")
    public String showFormForAddImage(@PathVariable("productId") int productId, Model model){
        ProductImageDto productImageDto = new ProductImageDto();
        model.addAttribute("productImage",productImageDto);
        model.addAttribute("productId",productId);
        return "admin/product-image-form";
    }
    @GetMapping("/image/showFormForUpdate/{productId}")
    public String showFormForUpdateImage(@PathVariable("productId") int productId,@RequestParam("productImageId")int id ,Model model){
        ProductImageDto productImageDto = productImageService.findById(id);
        model.addAttribute("productImage",productImageDto);
        model.addAttribute("productId",productId);
        return "admin/product-image-form";
    }
    @PostMapping("/image/save/{productId}")
    public String saveImage(@PathVariable("productId") int productId,@ModelAttribute("productImage")@Valid ProductImageDto productImageDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/product-image-form";
        }
        productImageService.save(productId,productImageDto);
        return "redirect:/admin/product/image/"+productId;
    }
    @GetMapping("/image/delete")
    public String deleteImage(@RequestParam("productId") int productId,@RequestParam("productImageId") int id){
        productImageService.deleteById(id);
        return "redirect:/admin/product/image/"+productId;
    }
}
