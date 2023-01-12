/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.dto;

import com.argprog.portfolio.model.progressDataDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class SkillsDataDTO implements Serializable {
    private List<progressDataDAO> softSkillsData;
    private List<progressDataDAO> languagesData;

    public List<progressDataDAO> getSoftSkillsData() {
        return softSkillsData;
    }

    public void setSoftSkillsData(List<progressDataDAO> softSkillsData) {
        this.softSkillsData = softSkillsData;
    }

    public List<progressDataDAO> getLanguagesData() {
        return languagesData;
    }

    public void setLanguagesData(List<progressDataDAO> languagesData) {
        this.languagesData = languagesData;
    }
}
