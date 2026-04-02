package com.asmita.ecommerce.controller;

import com.asmita.ecommerce.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> user) {

        String email = user.get("email");
        String password = user.get("password");

        // Safe null check (VERY IMPORTANT)
        if (email == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email and password required"));
        }

        // Dummy validation
        if (email.equals("asmita@gmail.com") && password.equals("1234")) {

            String token = jwtUtil.generateToken(email);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}