/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class JWTTokenValidator {
    
    @Autowired
    JWTTokenProvider tokenProvider;
    
    private final String secret="dawjfiaodncaweuauoufhasodcuibfhjsfhasjkavfscerncyuiiuaysdcjajieiufyfgas";
    
    public void validateToken(String token) throws Exception{
        try{
            Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
        }
        catch(ExpiredJwtException e){
            throw new Exception("The token has expired");
        }
    }
}
