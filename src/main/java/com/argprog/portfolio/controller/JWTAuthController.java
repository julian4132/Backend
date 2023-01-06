/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.JwtRequestDTO;
import com.argprog.portfolio.dto.JwtResponseDTO;
import com.argprog.portfolio.dto.RefreshRequestDTO;
import com.argprog.portfolio.dto.UserDTO;
import com.argprog.portfolio.model.RefreshTokenDAO;
import com.argprog.portfolio.security.JWTTokenProvider;
import com.argprog.portfolio.service.JwtUserDetailsService;
import com.argprog.portfolio.service.RefreshTokenService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    @Autowired
    private RefreshTokenService refreshTokenService;
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createJWT(@RequestBody JwtRequestDTO authData) throws Exception {
        auth(authData.getUsername(), authData.getPassword());
        
        final UserDetails user_details = userDetailsService.loadUserByUsername(authData.getUsername());        
        final String token = tokenProvider.generateToken(user_details);
        final RefreshTokenDAO refreshToken = refreshTokenService.newToken(authData.getUsername());
        return ResponseEntity.ok(new JwtResponseDTO(token, refreshToken.getSecret()));
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }
    
    private void auth(String username, String password)
            throws DisabledException, BadCredentialsException { //name the exceptions
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)
            );   
    }
    
    @RequestMapping(value="/refreshtoken", method = RequestMethod.POST)
    public ResponseEntity<?> refreshJWT(@RequestBody RefreshRequestDTO request){
        String refreshToken = request.getRefreshToken();
        Optional<RefreshTokenDAO> refreshData = refreshTokenService.findBySecret(refreshToken);
        
        return refreshData.map(data -> {
            final UserDetails user_details = userDetailsService.loadUserByUsername(data.getUser().getUsername());
            final String token = tokenProvider.generateToken(user_details);
            return ResponseEntity.ok(new JwtResponseDTO(token, null));
        }).orElseThrow(() -> new BadCredentialsException("Invalid refresh token supplied"));
    }
    
    
    
}
