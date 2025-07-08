package com.secuirty.jwt.controller;

import com.secuirty.jwt.entity.AuthRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/authenticate")
    public String generateToken(){
        // Here you would typically authenticate the user and generate a JWT token

        return "Token String";
    }
}
