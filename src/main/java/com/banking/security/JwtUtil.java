package com.banking.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey"; // 32+ chars
    private final long EXPIRATION = 1000 * 60 * 60 * 10; // 10 hours

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // ✅ GENERATE TOKEN
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // ✅ FIXED
                .setIssuedAt(new Date()) // ✅ FIXED
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)) // ✅ FIXED
                .signWith(getSignKey())
                .compact();
    }

    // ✅ EXTRACT USERNAME
    public String extractUsername(String token) {
        return Jwts.parserBuilder() // ✅ FIXED
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // ✅ VALIDATE TOKEN
    public boolean validateToken(String token, String username) {
        try {
            String extracted = extractUsername(token);
            return extracted.equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}