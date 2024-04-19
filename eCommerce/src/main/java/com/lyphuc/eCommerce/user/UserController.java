package com.lyphuc.eCommerce.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>>getUsers(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<UserDto> user = userService.findAll();
        model.addAttribute("users",user);
        return "admin/user-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user",user);
        return "admin/user-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int id, Model model){
        UserDto user = userService.findById(id);
        model.addAttribute("user",user);
        return "admin/user-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/user-form";
        }
        userService.save(userDto);
        return "redirect:/admin/user/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int id){
        userService.deleteById(id);
        return "redirect:/admin/user/list";
    }
}
