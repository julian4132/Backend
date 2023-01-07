/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.security;

import io.jsonwebtoken.Claims;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Usuario
 */

@Component
public class JWTTokenProvider implements Serializable {
 
    private static final long serialVersionUID=-5671247123L;
    private static final long TOKEN_VALIDITY_PERIOD=5*60*1000; //five minutes
    
    //@Value("${jwt.secret}")
    private final String secret="dawjfiaodncaweuauoufhasodcuibfhjsfhasjkavfscerncyuiiuaysdcjajieiufyfgas";
    private final SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    
    public String generateToken(UserDetails user_details){
        Instant expiration = Instant.now().plusMillis(TOKEN_VALIDITY_PERIOD);
        
        return Jwts.builder()
                .setSubject(user_details.getUsername()+"")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(expiration))
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }
    
    public Claims getAllClaimsFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    public String getUsernameFromToken(String token){
        return getAllClaimsFromToken(token).getSubject();
    }
    
    public Date getExpirationDateFromToken(String token){
        return getAllClaimsFromToken(token).getExpiration();
    }

    boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }
}
