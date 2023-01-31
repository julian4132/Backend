/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.service;

import com.argprog.portfolio.repository.UserRepository;
import com.argprog.portfolio.model.PortfolioUserDataDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */

@Service
public class PublicDataService {
    private final UserRepository userRepository;
    
    @Autowired
    public PublicDataService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    
    public PortfolioUserDataDAO fetchData(){
        return userRepository.findByUsername("usuario_argprog").getPortfolioUserData();
    }
}
