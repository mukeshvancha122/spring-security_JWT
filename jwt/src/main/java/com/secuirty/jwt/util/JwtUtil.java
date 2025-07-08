package com.secuirty.jwt.util;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
    private final String SECRET_KEY = "secret";
    public String generateToken(String username) {
        Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        return "generated-jwt-token-for-" + username;
    }
}
