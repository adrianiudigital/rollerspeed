package com.rollerspeed.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirect")
    public String redirectAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"))) {
            return "redirect:/instructor";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
            return "redirect:/student";
        }
        return "redirect:/";
    }
}
