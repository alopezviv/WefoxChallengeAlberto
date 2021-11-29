package com.api.pokemon.restful.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class TokenCreator {

    public String generateToken(String name){
        String secretKey = "%D*G-KaPdRgUkXp2s5v8y/B?E(H+MbQe";
        String compactTokenString = Jwts.builder()
                .setSubject(name)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes()).compact();


        return "Bearer " + compactTokenString;
    }
}
