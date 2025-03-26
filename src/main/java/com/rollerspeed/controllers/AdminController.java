// ✅ AdminController se mantiene igual, ya es correcto y funcional
package com.rollerspeed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.dtos.UserDTO;
import com.rollerspeed.mappers.UserMapper;
import com.rollerspeed.repositories.UserRepository;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin_dashboard";
    }

    @GetMapping("/users")
    public String viewUsers(Model model) {
        List<UserDTO> users = new UserMapper().toDTOList(userRepository.findAll());
        model.addAttribute("users", users);
        return "admin_users";
    }
}
