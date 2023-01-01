/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.JwtRequestDTO;
import com.argprog.portfolio.dto.JwtResponseDTO;
import com.argprog.portfolio.security.JWTTokenProvider;
import com.argprog.portfolio.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Usuario
 */
public class JWTAuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JWTTokenProvider tokenProvider;
    
    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createJWT(@RequestBody JwtRequestDTO authData) throws Exception {
        auth(authData.getUsername(), authData.getPassword());
        
        final UserDetails user_details = userDetailsService.loadUserByUsername(authData.getUsername());        
        final String token = tokenProvider.generateToken(user_details);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
    
    private void auth(String username, String password)
            throws DisabledException, BadCredentialsException { //name the exceptions
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)
            );   
    }
    
    
    
}
