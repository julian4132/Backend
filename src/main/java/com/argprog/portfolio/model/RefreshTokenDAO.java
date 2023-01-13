/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="refresh_token")
@NoArgsConstructor
public class RefreshTokenDAO {

    public long getId() {
        return Id;
    }

    public RefreshTokenDAO() {
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public Instant getExpiry() {
        return expiry;
    }

    public void setExpiry(Instant expiry) {
        this.expiry = expiry;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    
    
    @OneToOne(optional=false)
    @JoinColumn(name="user_id", unique=true)
    private UserDAO user;
    
    @Column
    private Instant expiry;
    
    @Column
    private String secret;
    
    public RefreshTokenDAO(Long Id, UserDAO user, Instant expiry){
        this.Id=Id;
        this.user=user;
        this.expiry=expiry;
    }
}
