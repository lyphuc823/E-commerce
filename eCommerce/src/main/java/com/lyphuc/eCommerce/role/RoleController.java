package com.lyphuc.eCommerce.role;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<RoleDto> roleDtos = roleService.findAll();
        model.addAttribute("roles",roleDtos);
        return "admin/role-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        RoleDto roleDto = new RoleDto();
        model.addAttribute("role",roleDto);
        return "admin/role-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("roleId")int id, Model model){
        RoleDto roleDto = roleService.findById(id);
        model.addAttribute("role",roleDto);
        return "admin/role-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("role")@Valid RoleDto roleDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/role-form";
        }
        roleService.save(roleDto);
        return "redirect:/admin/role/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("roleId") int id){
        roleService.deleteById(id);
        return "redirect:/admin/role/list";
    }
}
