/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.dto;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class JwtResponseDTO implements Serializable {
    private static final long serialVersionUID = 2534523188239L;
    private final String token;
    
    public JwtResponseDTO(String token){
        this.token=token;
    }
    
    public String getToken(){
        return this.token;
    }
}
