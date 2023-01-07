/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.service;

import com.argprog.portfolio.model.PortfolioUserDataDAO;
import com.argprog.portfolio.model.UserDAO;
import com.argprog.portfolio.repository.UserRepository;
import com.argprog.portfolio.security.JWTTokenProvider;
import com.argprog.portfolio.security.JWTTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class FetchDataService {
    
    private final JWTTokenProvider tokenProvider;
    private final JWTTokenValidator tokenValidator;
    private final UserRepository userRepository;
    
    @Autowired
    public FetchDataService(JWTTokenProvider tokenProvider, JWTTokenValidator tokenValidator, UserRepository userRepository){
        this.tokenProvider=tokenProvider;
        this.tokenValidator=tokenValidator;
        this.userRepository=userRepository;
    }
    
    public PortfolioUserDataDAO FetchDataFromToken(String token) throws Exception{
        tokenValidator.validateToken(token);
        String username = tokenProvider.getUsernameFromToken(token);
        UserDAO user = userRepository.findByUsername(username);
        return user.getPortfolioUserData();
    }
    
}
