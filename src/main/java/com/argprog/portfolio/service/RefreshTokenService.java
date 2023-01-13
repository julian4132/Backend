/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.service;

import com.argprog.portfolio.model.RefreshTokenDAO;
import com.argprog.portfolio.repository.RefreshTokenRepository;
import com.argprog.portfolio.repository.UserRepository;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class RefreshTokenService {
    
    private final RefreshTokenRepository refreshTokenRepository;
    
    private final UserRepository userRepository;
    
    private final long REFRESH_VALIDITY_PERIOD = 7*24*60*60*1000; //one week
    
    @Autowired
    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository){
        this.refreshTokenRepository=refreshTokenRepository;
        this.userRepository=userRepository;
    }
    
    public RefreshTokenDAO newToken(String username){
        RefreshTokenDAO tokenDAO = new RefreshTokenDAO();
        tokenDAO.setUser(userRepository.findByUsername(username));
        tokenDAO.setExpiry(Instant.now().plusMillis(REFRESH_VALIDITY_PERIOD));
        tokenDAO.setSecret(UUID.randomUUID().toString());
        return tokenDAO;
    }
    
    public void save(RefreshTokenDAO token){
        refreshTokenRepository.save(token);
    }
    
    public Optional<RefreshTokenDAO> findById(Long Id){
        return refreshTokenRepository.findById(Id);
    }
    
    public Optional<RefreshTokenDAO> findBySecret(String token){
        return refreshTokenRepository.findBySecret(token);
    }
    
    public long invalidateRefreshToken(String token){
        return refreshTokenRepository.deleteBySecret(token);
    }
}
