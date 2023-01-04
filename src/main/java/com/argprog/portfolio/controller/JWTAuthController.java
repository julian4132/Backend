/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.JwtRequestDTO;
import com.argprog.portfolio.dto.JwtResponseDTO;
import com.argprog.portfolio.dto.UserDTO;
import com.argprog.portfolio.security.JWTTokenProvider;
import com.argprog.portfolio.service.JwtUserDetailsService;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;


/**
 *
 * @author Usuario
 */

@RestController
@CrossOrigin
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
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }
    
    @RequestMapping(value="/refreshtoken", method = RequestMethod.GET)
    public ResponseEntity<?> refreshJWT(HttpServletRequest http){
        /*String token = tokenProvider.generateRefreshToken(claims, claims.get("sub").toString());
        System.out.println("hooolaaaa");
        return ResponseEntity.ok(new JwtResponseDTO(token));*/
        return ResponseEntity.ok("hola");
    }
    
    private void auth(String username, String password)
            throws DisabledException, BadCredentialsException { //name the exceptions
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)
            );   
    }
    
    
    
}
