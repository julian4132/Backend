/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    
    @Column
    private String username;
    
    private String email;
    
    @JsonIgnore
    private String password;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PortfolioUserDataDAO getPortfolioUserData() {
        return portfolioUserData;
    }

    public void setPortfolioUserData(PortfolioUserDataDAO portfolioUserData) {
        this.portfolioUserData = portfolioUserData;
    }
    
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="data_id")
    private PortfolioUserDataDAO portfolioUserData;
}
