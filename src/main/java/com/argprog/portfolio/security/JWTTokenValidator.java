/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.security.authentication.BadCredentialsException;

/**
 *
 * @author Usuario
 */
@Component
public class JWTTokenValidator {
    
    /*@Autowired
    JWTTokenProvider tokenProvider;*/
    private final String secret="dawjfiaodncaweuauoufhasodcuibfhjsfhasjkavfscerncyuiiuaysdcjajieiufyfgas";
    
    public void validateToken(String token){
        /*final String username = tokenProvider.getUsernameFromToken(token);
        return (username.equals(user_details.getUsername()) && !tokenProvider.isTokenExpired(token));*/
        try {
            Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
        } catch (ExpiredJwtException e) {
            throw e;
        }
    }
}
