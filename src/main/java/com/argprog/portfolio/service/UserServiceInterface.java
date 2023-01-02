/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.portfolio.service;

import com.argprog.portfolio.model.UserDAO;

/**
 *
 * @author Usuario
 */
public interface UserServiceInterface {
    public void saveUser(UserDAO usr);
    public void editUser(Long id, UserDAO newdata);
    public void deleteUser(Long id);
}
