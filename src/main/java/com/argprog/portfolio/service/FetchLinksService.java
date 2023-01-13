/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.service;

import com.argprog.portfolio.model.LinksListDAO;
import com.argprog.portfolio.repository.LinksListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class FetchLinksService {
    
    private final LinksListRepository linksListRepository;
    
    @Autowired
    public FetchLinksService(LinksListRepository linksListRepository){
        this.linksListRepository = linksListRepository;
    }
    
    public LinksListDAO fetchLinksFromName(String name){
        return linksListRepository.findByName(name);
    }
}
