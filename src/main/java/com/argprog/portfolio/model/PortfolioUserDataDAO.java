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
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="portfolio_user_data")
@NoArgsConstructor
public class PortfolioUserDataDAO {

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getAboutText() {
        return aboutText;
    }

    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }

    public headerDataDAO getHeaderData() {
        return headerData;
    }

    public void setHeaderData(headerDataDAO headerData) {
        this.headerData = headerData;
    }
    
    public experienceDataDAO getExperienceData() {
        return experienceData;
    }

    public void setExperienceData(experienceDataDAO experienceData) {
        this.experienceData = experienceData;
    }
    
    public SkillsDataDAO getSkillsData() {
        return skillsData;
    }

    public void setSkillsData(SkillsDataDAO skillsData) {
        this.skillsData = skillsData;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    
    @Column
    private String aboutText;
    
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="header_id")
    private headerDataDAO headerData=new headerDataDAO();
    
    
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="experience_id")
    private experienceDataDAO experienceData=new experienceDataDAO();
    
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="skills_id")
    private SkillsDataDAO skillsData=new SkillsDataDAO();
}
