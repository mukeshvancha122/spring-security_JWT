package com.secuirty.jwt.controller;

import com.secuirty.jwt.entity.AuthRequest;
import com.secuirty.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    public String generateToken(){
        // Here you would typically authenticate the user and generate a JWT token

        return "Hello";
    }

    @PostMapping("/generate-token")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
            );
            return jwtUtil.generateToken(authRequest.getUsername());
        }catch(Exception e){
            throw e;
        }

    }
}
