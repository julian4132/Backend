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
import jakarta.persistence.Table;
import java.util.List;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */

@Entity
@Table(name="experienceData")
@NoArgsConstructor
@AllArgsConstructor
public class experienceDataDAO {

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public List<ItemDataDAO> getExperienceData() {
        return experienceData;
    }

    public void setExperienceData(List<ItemDataDAO> experienceData) {
        this.experienceData = experienceData;
    }
    
    public List<ItemDataDAO> getEducationData() {
        return educationData;
    }

    public void setEducationData(List<ItemDataDAO> educationData) {
        this.educationData = educationData;
    }
    
    public List<ItemDataDAO> getProjectsData() {
        return projectsData;
    }

    public void setProjectsData(List<ItemDataDAO> projectsData) {
        this.projectsData = projectsData;
    }

    public List<ItemDataDAO> getAwardsData() {
        return awardsData;
    }

    public void setAwardsData(List<ItemDataDAO> awardsData) {
        this.awardsData = awardsData;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="experience_data_id")
    private List<ItemDataDAO> experienceData=new ArrayList<ItemDataDAO>();
    
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="education_data_id")
    private List<ItemDataDAO> educationData=new ArrayList<ItemDataDAO>();
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="projects_data_id")
    private List<ItemDataDAO> projectsData=new ArrayList<ItemDataDAO>();
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="awards_data_id")
    private List<ItemDataDAO> awardsData=new ArrayList<ItemDataDAO>();
}
