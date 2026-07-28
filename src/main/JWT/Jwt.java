package com.gestion_de_note.gestion_de_note.JWT;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class Jwt {

    private final String SECRET = "MySuperSecretKeyForJWTTrainingApplication2026";
    private final SecretKey  KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generatetokens(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(KEY)
                .compact();
    }

    public String getemailfromtkons(String token) {

        return Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}
