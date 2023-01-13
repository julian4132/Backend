/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.controller;

import com.argprog.portfolio.dto.LinksRequestDTO;
import com.argprog.portfolio.service.FetchLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = {"${settings.cors_origin}"})
public class FetchLinksController {
    
    private final FetchLinksService fetchLinksService;
    
    @Autowired
    public FetchLinksController(FetchLinksService fetchLinksService){
        this.fetchLinksService = fetchLinksService;
    }
    
    @RequestMapping(value = "/fetchlinks", method = RequestMethod.POST)
    public ResponseEntity<?> fetchLinks(@RequestBody LinksRequestDTO request){
        return ResponseEntity.ok(fetchLinksService.fetchLinksFromName(request.getName()));
    }
}
