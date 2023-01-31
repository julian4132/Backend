/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.controller;

import com.argprog.portfolio.service.PublicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */

@RestController
@CrossOrigin(origins = {"${settings.cors_origin}"})
public class PublicDataController {
    
    private final PublicDataService publicDataService;
    
    @Autowired
    public PublicDataController(PublicDataService publicDataService){
        this.publicDataService = publicDataService;
    }
    
    @RequestMapping(value="/publicdata", method=RequestMethod.POST)
    public ResponseEntity<?> fetchData(){
        return ResponseEntity.ok(publicDataService.fetchData());
    }
    
}
