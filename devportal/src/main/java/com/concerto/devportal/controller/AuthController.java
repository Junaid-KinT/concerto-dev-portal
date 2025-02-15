package com.concerto.devportal.controller;

import com.concerto.devportal.dto.UserDTO;
import com.concerto.devportal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDTO user) {
        userService.saveUser(user);
        return "redirect:/registration?success";
    }

    @GetMapping("/getLoginPage")
    public String getLoginPage() {
        return "auth/loginPage";
    }

}
