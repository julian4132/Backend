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
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Usuario
 */
@Component
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
        
        //System.out.println("jurujujaja");
        try{
            if(header!=null && header.startsWith("Bearer ")){
                String token = header.substring(7);
           
                System.out.println("Va queriendo");
                tokenValidator.validateToken(token);
                UserDetails userDetails = new User(tokenProvider.getUsernameFromToken(token), "", new ArrayList<>());

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            else{
                //System.out.println("No es refresh token");
            }
            
        }   catch (IllegalArgumentException e) {
                System.out.println("Invalid Token format");
        }   catch (ExpiredJwtException e) {
                //System.out.println("Expired token");
                String isRefreshToken = request.getHeader("isRefreshToken");
                String requestURL = request.getRequestURL().toString();
                if(isRefreshToken!=null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken")){
                    acceptRefreshToken(e, request);
                }
            }
            catch (BadCredentialsException e){
                System.out.println("Te tengo");
                throw new BadCredentialsException("INVALID_CREDENTIALS", e);
            }
        
        /*if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails user_details = userDetailsService.loadUserByUsername(username);
            
            tokenValidator.validateToken(token);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    user_details, null, user_details.getAuthorities());
                    usernamePasswordAuthenticationToken
                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // After setting the Authentication in the context, we specify
            // that the current user is authenticated. So it passes the
            // Spring Security Configurations successfully.
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }           */
        chain.doFilter(request, response);
    }

    private void acceptRefreshToken(ExpiredJwtException e, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(null, null, null);
        SecurityContextHolder.getContext().setAuthentication(token);
        request.setAttribute("claims", e.getClaims());
    }
}
