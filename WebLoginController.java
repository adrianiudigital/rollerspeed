package com.rollerspeed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rollerspeed.models.User;
import com.rollerspeed.services.UserService;

@Controller
public class WebLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userService.findByUsername(username);

            switch (user.getRole()) {
                case ADMIN:
                    return "redirect:/admin/dashboard";
                case INSTRUCTOR:
                    return "redirect:/instructor/dashboard";
                case STUDENT:
                    return "redirect:/student/dashboard";
                default:
                    return "redirect:/";
            }

        } catch (Exception e) {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }
}
