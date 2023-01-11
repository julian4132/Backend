/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.service;

import com.argprog.portfolio.dto.PortfolioDataMapper;
import com.argprog.portfolio.dto.UpdateRequestDTO;
import com.argprog.portfolio.model.PortfolioUserDataDAO;
import com.argprog.portfolio.model.UserDAO;
import com.argprog.portfolio.repository.UserRepository;
import com.argprog.portfolio.security.JWTTokenProvider;
import com.argprog.portfolio.security.JWTTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Usuario
 */
public class UpdateDataService {
    private final JWTTokenProvider tokenProvider;
    private final JWTTokenValidator tokenValidator;
    private final UserRepository userRepository;
    private final PortfolioDataMapper dataMapper;
    
    @Autowired
    public UpdateDataService(JWTTokenProvider tokenProvider, JWTTokenValidator tokenValidator, UserRepository userRepository, PortfolioDataMapper dataMapper){
        this.tokenProvider=tokenProvider;
        this.tokenValidator=tokenValidator;
        this.userRepository=userRepository;
        this.dataMapper=dataMapper;
    }
    
    public void UpdateDataFromToken(String token, UpdateRequestDTO updateData) throws Exception{
        tokenValidator.validateToken(token);
        String username = tokenProvider.getUsernameFromToken(token);
        UserDAO user = userRepository.findByUsername(username);
        dataMapper.updatePortfolioDataFromDto(updateData, user.getPortfolioUserData());
    }
}
