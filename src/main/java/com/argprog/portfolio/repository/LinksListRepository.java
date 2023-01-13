/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.portfolio.repository;

import com.argprog.portfolio.model.LinksListDAO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface LinksListRepository extends JpaRepository<LinksListDAO, Long>{
    public LinksListDAO findByName(String name);
}
