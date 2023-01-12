/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.dto;

import com.argprog.portfolio.model.ItemDataDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EducationDataDTO implements Serializable {
    private List<ItemDataDAO> educationData;

    public List<ItemDataDAO> getEducationData() {
        return educationData;
    }

    public void setEducationData(List<ItemDataDAO> educationData) {
        this.educationData = educationData;
    }
}
