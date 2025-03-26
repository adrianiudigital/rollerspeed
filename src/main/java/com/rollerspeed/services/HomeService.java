package com.rollerspeed.services;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rollerspeed.dtos.ClassScheduleDTO;
import com.rollerspeed.dtos.PaymentDTO;
import com.rollerspeed.dtos.UserDTO;
import com.rollerspeed.dtos.UserMinimalDTO;
import com.rollerspeed.models.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class HomeService {

    @Autowired
    private UserService userService;

    @Autowired
    private ClassScheduleService classScheduleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private PaymentService paymentService;

    public String processLogin(String username, String password, Model model, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest();
            request.getSession(true);
            request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            User user = userService.findByUsername(username);
            String role = user.getRole().name();
            Cookie roleCookie = new Cookie("USER_ROLE", role);
            roleCookie.setPath("/");
            roleCookie.setHttpOnly(false);
            roleCookie.setMaxAge(60 * 30);
            response.addCookie(roleCookie);
            return "redirect:/redirector";

        } catch (Exception e) {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }

    public String registerUser(UserDTO userDTO, RedirectAttributes redirectAttributes) {
        try {
            userService.saveUser(userDTO);
            redirectAttributes.addFlashAttribute("success", "User successfully registered.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error while registering user: " + e.getMessage());
        }
        return "redirect:/dashboard/admin/users";
    }

    public String adminDashboard(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "admin-dashboard";
    }

    public String instructorDashboard(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "instructor-dashboard";
    }

    public String studentDashboard(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "student-dashboard";
    }

    public String studentSchedule(Model model, Principal principal) {
        User student = userService.findByUsername(principal.getName());
        List<ClassScheduleDTO> classes = classScheduleService.getClassesByStudent(student.getId());
        model.addAttribute("classes", classes);
        return "student/schedule";
    }

    public String studentPayments(Model model, Principal principal) {
        User student = userService.findByUsername(principal.getName());
        List<PaymentDTO> payments = paymentService.getPaymentsByStudent(student.getId());
        model.addAttribute("user", student);
        model.addAttribute("payments", payments);
        return "student/payments";
    }

    public String instructorSchedule(Model model, Principal principal) {
        User instructor = userService.findByUsername(principal.getName());
        List<ClassScheduleDTO> classes = classScheduleService.getClassesByInstructor(instructor.getId());
        model.addAttribute("classes", classes);
        return "instructor/schedule";
    }

    public String adminUsers(Model model) {
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/admin_users";
    }

    public String adminSchedule(Model model) {
        List<ClassScheduleDTO> classes = classScheduleService.getAllClasses();
        model.addAttribute("classes", classes);
        return "admin/schedule";
    }

    public ResponseEntity<UserMinimalDTO> getUserFromToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().build();
        }
        String token = authHeader.substring(7);
        return authService.getCurrentUser(token)
                .map(user -> ResponseEntity.ok(
                        UserMinimalDTO.builder()
                                .username(user.getUsername())
                                .role(user.getRole().name())
                                .build()))
                .orElse(ResponseEntity.status(401).build());
    }
}
