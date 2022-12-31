/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.security;

import com.argprog.portfolio.service.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Usuario
 */
public class JwtRequestFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired
    private JWTTokenProvider tokenProvider;
    
    @Autowired
    private JWTTokenValidator tokenValidator;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException{
        final String header = request.getHeader("Authorization");
        String username = null;
        String token = null;
        if(header!=null && header.startsWith("Bearer ")){
            token = header.substring(7);
            try{
               username = tokenProvider.getUsernameFromToken(token);
            }
            catch (IllegalArgumentException e) {
        	System.out.println("Invalid Token format");
            } catch (ExpiredJwtException e) {
                System.out.println("Expired token");
            }
        }
        else{
            //throw an exception
        }
        
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails user_details = userDetailsService.loadUserByUsername(username);
            
            if(tokenValidator.validateToken(token, user_details)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        user_details, null, user_details.getAuthorities());
                        usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            
        }
        
        chain.doFilter(request, response);
    }
}
