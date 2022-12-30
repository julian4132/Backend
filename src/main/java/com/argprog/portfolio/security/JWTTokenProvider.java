/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.security;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */

@Component
public class JWTTokenProvider implements Serializable {
 
    private static final long serialVersionUID=-5671247123L;
    private static final long tokenValidityPeriod=5*60; //five minutes
    @Value("${jwt.secret}")
    private String secret;
    
}
