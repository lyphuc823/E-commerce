package com.lyphuc.eCommerce.specification;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/specification")
public class SpecificationController {
    private SpecificationService specificationService;

    public SpecificationController(SpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<SpecificationDto> specificationDtos = specificationService.findAll();
        model.addAttribute("specifications",specificationDtos);
        return "admin/specification-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        SpecificationDto specificationDto = new SpecificationDto();
        model.addAttribute("specification", specificationDto);
        return "admin/specification-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("specificationId")int id, Model model){
        SpecificationDto specificationDto = specificationService.findById(id);
        model.addAttribute("specification",specificationDto);
        return "admin/specification-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("specification") @Valid SpecificationDto specificationDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/specification-form";
        }
        specificationService.save(specificationDto);
        return "redirect:/admin/specification/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("specificationId") int id){
        specificationService.deleteById(id);
        return "redirect:/admin/specification/list";
    }
}
