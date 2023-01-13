/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.portfolio.repository;

import com.argprog.portfolio.model.RefreshTokenDAO;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshTokenDAO, Long> {
    Optional<RefreshTokenDAO> findById(long Id);
    Optional<RefreshTokenDAO> findBySecret(String token);
    
    @Transactional
    long deleteBySecret(String token);
}
