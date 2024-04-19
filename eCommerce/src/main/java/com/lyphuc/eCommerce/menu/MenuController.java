package com.lyphuc.eCommerce.menu;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<MenuDto> menuDtos = menuService.findAll();
        model.addAttribute("menus",menuDtos);
        return "admin/menu-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        MenuDto menuDto = new MenuDto();
        model.addAttribute("menu",menuDto);
        return "admin/menu-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("menuId") int id, Model model){
        MenuDto menuDto = menuService.findById(id);
        model.addAttribute("menu",menuDto);
        return "admin/menu-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("menu") @Valid MenuDto menuDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/menu-form";
        }
        menuService.save(menuDto);
        return "redirect:/admin/menu/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("menuId") int id, Model model){
        menuService.deleteById(id);
        return "redirect:/admin/menu/list";
    }
}
