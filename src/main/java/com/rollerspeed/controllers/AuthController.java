package com.rollerspeed.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.rollerspeed.models.User;
import com.rollerspeed.repositories.UserRepository;
import com.rollerspeed.security.JwtUtil;
import com.rollerspeed.security.TokenBlacklist;

@RestController
@RequestMapping("${api.auth.base}")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenBlacklist tokenBlacklist;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtil.generateToken(user.getUsername());

        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario autenticado correctamente");
        response.put("token", token);
        return response;
    }

    @PostMapping("/refresh")
    public Map<String, String> refreshToken(@RequestHeader("Authorization") String oldToken) {
        String username = jwtUtil.extractUsername(oldToken.replace("Bearer ", ""));
        String newToken = jwtUtil.generateToken(username);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Token refrescado correctamente");
        response.put("token", newToken);

        return response;
    }

    @GetMapping("/me")
    public User getCurrentUser(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.extractUsername(token.replace("Bearer ", ""));
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("No se proporcionó un token válido");
        }
        String token = authHeader.substring(7);
        tokenBlacklist.addToken(token);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout exitoso; token invalidado");
        return ResponseEntity.ok(response);
    }
}
