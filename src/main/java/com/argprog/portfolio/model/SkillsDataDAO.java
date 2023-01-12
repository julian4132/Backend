/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="skills")
public class SkillsDataDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="softskills_data_id")
    @OrderColumn
    private List<progressDataDAO> softSkillsData=new ArrayList<progressDataDAO>();
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="languages_data_id")
    @OrderColumn
    private List<progressDataDAO> languagesData=new ArrayList<progressDataDAO>();

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

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
