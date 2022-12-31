/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Usuario
 */
public class JWTTokenValidator {
    
    @Autowired
    JWTTokenProvider tokenProvider;
    
    public Boolean validateToken(String token, UserDetails user_details){
        final String username = tokenProvider.getUsernameFromToken(token);
        return (username.equals(user_details.getUsername()) && !tokenProvider.isTokenExpired(token));
    }
}
