package com.lyphuc.eCommerce.productImage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/product-image")
public class ProductImageController {
//    private ProductImageService productImageService;
//
//    public ProductImageController(ProductImageService productImageService) {
//        this.productImageService = productImageService;
//    }

//    @GetMapping("/{productId}")
//    public String getList(@PathVariable("productId")int productId, Model model){
//        List<ProductImageDto> productImageDtos =productImageService.findByProductId(productId);
//        model.addAttribute("productImages",productImageDtos);
//        return "admin/product-image-list";
//    }
//    @GetMapping("/showFormForAdd/{productId}")
//    public String showFormForAdd(@PathVariable("productId") int productId, Model model){
//        ProductImageDto productImageDto = new ProductImageDto();
//        model.addAttribute("productImage",productImageDto);
//        model.addAttribute("productId",productId);
//        return "admin/product-image-form";
//    }
//    @GetMapping("/showFormForUpdate/{productId}")
//    public String showFormForUpdate(@PathVariable("productId") int productId,@RequestParam("productImageId")int id ,Model model){
//        ProductImageDto productImageDto = productImageService.findById(id);
//        model.addAttribute("productImage",productImageDto);
//        model.addAttribute("productId",productId);
//        return "admin/product-image-form";
//    }
//    @PostMapping("/save/{productId}")
//    public String save(@PathVariable("productId") int productId,@ModelAttribute("productImage")@Valid ProductImageDto productImageDto, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "admin/product-image-form";
//        }
//        productImageService.save(productId,productImageDto);
//        return "redirect:/admin/product/list";
//    }
//    @GetMapping("/delete")
//    public String delete(@RequestParam("productImageId") int id){
//        productImageService.deleteById(id);
//        return "redirect:/admin/product/list";
//    }
}
