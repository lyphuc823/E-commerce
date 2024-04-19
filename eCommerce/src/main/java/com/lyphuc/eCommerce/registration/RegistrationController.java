package com.lyphuc.eCommerce.registration;

import com.lyphuc.eCommerce.registration.RegisterDto;
import com.lyphuc.eCommerce.registration.RegistrationCompleteEvent;
import com.lyphuc.eCommerce.registration.token.VerificationToken;
import com.lyphuc.eCommerce.registration.token.VerificationTokenRepository;
import com.lyphuc.eCommerce.registration.token.VerificationTokenService;
import com.lyphuc.eCommerce.user.UserEntity;
import com.lyphuc.eCommerce.user.UserService;
import com.lyphuc.eCommerce.utility.UrlUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenService tokenService;
//    @GetMapping("/registration-form")
//    public String showRegistrationForm(Model model){
//        model.addAttribute("user", new RegisterDto());
//        return "login-register";
//    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegisterDto registerDto, HttpServletRequest request){
        UserEntity userEntity = userService.registerUser(registerDto);
        publisher.publishEvent(new RegistrationCompleteEvent(userEntity, UrlUtil.getApplicationUrl(request)));
        return "redirect:/login-register?success";
    }
    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        Optional<VerificationToken> theToken = tokenService.findByToken(token);
        if(theToken.isPresent() && theToken.get().getUser().isEnabled()){
            return "redirect:/login-register?verified";
        }
        String verificationResult = tokenService.validateToken(String.valueOf(theToken));
        if(verificationResult.equalsIgnoreCase("invalid")){
            return "redirect:/error?invalid";
        }else if(verificationResult.equalsIgnoreCase("expired")){
            return "redirect:/error?expired";
        }else if(verificationResult.equalsIgnoreCase("valid")){
            return "redirect:/login-register?valid";
        }
        return "redirect:/error?invalid";
    }
}
