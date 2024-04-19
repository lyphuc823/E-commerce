package com.lyphuc.eCommerce.provider;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/provider")
public class ProviderController {
    private ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<ProviderDto> providerDtos = providerService.findAll();
        model.addAttribute("providers",providerDtos);
        return "admin/provider-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        ProviderDto providerDto = new ProviderDto();
        model.addAttribute("provider",providerDto);
        return "admin/provider-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("providerId")int id, Model model){
        ProviderDto providerDto = providerService.findById(id);
        model.addAttribute("provider",providerDto);
        return "admin/provider-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("provider")@Valid ProviderDto providerDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/provider-form";
        }
        providerService.save(providerDto);
        return "redirect:/admin/provider/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("providerId") int id){
        providerService.deleteById(id);
        return "redirect:/admin/provider/list";
    }

}
