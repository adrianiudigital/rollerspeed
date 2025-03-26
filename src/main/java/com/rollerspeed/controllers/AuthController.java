package com.rollerspeed.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rollerspeed.models.User;
import com.rollerspeed.services.AuthService;

@RestController
@RequestMapping("${api.auth.base}")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (authService.usernameExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("Error: El nombre de usuario ya está en uso.");
        }

        if (authService.emailExists(user.getEmail())) {
            return ResponseEntity.badRequest().body("Error: El correo ya está registrado.");
        }

        authService.register(user);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
        String token = authService.login(user.getUsername(), user.getPassword());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario autenticado correctamente");
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@RequestHeader("Authorization") String token) {
        return authService.getCurrentUser(token)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body(Map.of("message", "No se proporcionó un token válido"));
        }
        authService.logout(authHeader.substring(7));
        return ResponseEntity.ok(Map.of("message", "Logout exitoso; token invalidado"));
    }
}
