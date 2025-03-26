package com.rollerspeed.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rollerspeed.dtos.ClassScheduleDTO;
import com.rollerspeed.dtos.UserDTO;
import com.rollerspeed.dtos.UserMinimalDTO;
import com.rollerspeed.services.HomeService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/mission")
    public String mission() {
        return "mission";
    }

    @GetMapping("/vision")
    public String vision() {
        return "vision";
    }

    @GetMapping("/values")
    public String values() {
        return "values";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/events")
    public String events() {
        return "events";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpServletResponse response) {
        return homeService.processLogin(username, password, model, response);
    }

    @GetMapping("/redirector")
    public String redirectorPage() {
        return "redirector";
    }

    @GetMapping("/my-user")
    @ResponseBody
    public ResponseEntity<UserMinimalDTO> getUserFromToken(@RequestHeader("Authorization") String authHeader) {
        return homeService.getUserFromToken(authHeader);
    }

    // ================== ADMIN ==================
    @GetMapping("/admin")
    public String adminShortcut() {
        return "redirect:/dashboard/admin";
    }

    @GetMapping("/admin/register")
    public String registerPage() {
        return "admin/register";
    }

    @PostMapping("/admin/register")
    public String registerPost(@ModelAttribute("user") UserDTO userDTO, RedirectAttributes redirectAttributes) {
        return homeService.registerUser(userDTO, redirectAttributes);
    }

    @GetMapping("/dashboard/admin")
    public String adminDashboard(Model model, Principal principal) {
        return homeService.adminDashboard(model, principal);
    }

    @GetMapping("/dashboard/admin/schedule")
    @PreAuthorize("hasRole('ADMIN')")
    public String showSchedulePage(Model model) {
        return homeService.adminSchedule(model);
    }

    @GetMapping("/dashboard/admin/payments")
    public String showPaymentsPage() {
        return "admin/payments";
    }

    @GetMapping("/dashboard/admin/attendance")
    public String showAttendancePage() {
        return "admin/attendance";
    }

    @GetMapping("/dashboard/admin/users")
    public String showUsersPage(Model model) {
        return homeService.adminUsers(model);
    }

    // ================== INSTRUCTOR ==================
    @GetMapping("/instructor")
    public String instructorShortcut() {
        return "redirect:/dashboard/instructor";
    }

    @GetMapping("/dashboard/instructor")
    public String instructorDashboard(Model model, Principal principal) {
        return homeService.instructorDashboard(model, principal);
    }

    @GetMapping("/dashboard/instructor/schedule")
    public String showInstructorSchedule(Model model, Principal principal) {
        return homeService.instructorSchedule(model, principal);
    }

    @GetMapping("/dashboard/instructor/attendance")
    public String showInstructorAttendance(Model model, Principal principal) {
        return "redirect:/dashboard/instructor";
    }

    // ================== STUDENT ==================
    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student")
    public String studentShortcut() {
        return "redirect:/dashboard/student";
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/dashboard/student")
    public String studentDashboard(Model model, Principal principal) {
        return homeService.studentDashboard(model, principal);
    }

    @GetMapping("/dashboard/student/schedule")
    @PreAuthorize("hasRole('STUDENT')")
    public String showStudentSchedule(Model model, Principal principal) {
        return homeService.studentSchedule(model, principal);
    }

    @GetMapping("/dashboard/student/payments")
    @PreAuthorize("hasRole('STUDENT')")
    public String showStudentPayments(Model model, Principal principal) {
        return homeService.studentPayments(model, principal);
    }

}
