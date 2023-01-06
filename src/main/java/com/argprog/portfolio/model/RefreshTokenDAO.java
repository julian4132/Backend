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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="refresh_token")
@Setter @Getter
@NoArgsConstructor
public class RefreshTokenDAO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    
    
    @Column
    /*@OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id", unique=true)*/
    private String username;
    
    @Column
    private Instant expiry;
    
    @Column
    private String secret;
    
    public RefreshTokenDAO(Long Id, String username, Instant expiry){
        this.Id=Id;
        this.username=username;
        this.expiry=expiry;
    }
}
