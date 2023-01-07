/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.service;

import com.argprog.portfolio.model.PortfolioUserDataDAO;
import com.argprog.portfolio.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class PortfolioUserDataService {
    
    private final UserDataRepository userDataRepository;
    
    @Autowired
    public PortfolioUserDataService(UserDataRepository userDataRepository){
        this.userDataRepository=userDataRepository;
    }

    public PortfolioUserDataDAO createDefaultUserData(){
        PortfolioUserDataDAO userData = new PortfolioUserDataDAO();
        userData.setAboutText("Hola mundo");
        return userDataRepository.save(userData);
    }
    
}
