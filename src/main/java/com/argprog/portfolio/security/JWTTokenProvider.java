/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.security;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 *
 * @author Usuario
 */

@Component
public class JWTTokenProvider implements Serializable {
 
    private static final long serialVersionUID=-5671247123L;
    private static final long tokenValidityPeriod=5*60*1000; //five minutes
    
    @Value("${jwt.secret}")
    private String secret;
    
    public String generateToken(CustomUserDetails user_details){
        Instant expiration = Instant.now().plusMillis(tokenValidityPeriod);
        
        return Jwts.builder()
                .setSubject(customUserDetails.getId()+"")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
}
