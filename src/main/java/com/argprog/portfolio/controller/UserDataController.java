/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.controller;

import com.argprog.portfolio.security.JWTTokenProvider;
import com.argprog.portfolio.security.JWTTokenValidator;
import com.argprog.portfolio.service.FetchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */

@RestController
@CrossOrigin(origins = {"${settings.cors_origin}"})
public class UserDataController {
    
    private final FetchDataService fetchDataService;
    
    @Autowired
    public UserDataController(FetchDataService fetchDataService){
        this.fetchDataService=fetchDataService;
        
    }
    
    
    @RequestMapping(value="/data", method = RequestMethod.POST)
    public ResponseEntity<?> fetchData(@RequestHeader("Authorization") String authorizationHeader) throws Exception{
        String token = extractTokenFromHeader(authorizationHeader);
        return ResponseEntity.ok(fetchDataService.FetchDataFromToken(token));
        //fetchDataService.fetch
        //fetchDataService(token)
        //tokenValidator.validateToken(token);
    }
    
    private String extractTokenFromHeader(String authorizationHeader) throws Exception{
        if(authorizationHeader.startsWith("Bearer ")){
            return authorizationHeader.substring(7);
        }
        else{
            throw new Exception("Authorization request header should start with Bearer word");
        }
    }
    
    
    
}