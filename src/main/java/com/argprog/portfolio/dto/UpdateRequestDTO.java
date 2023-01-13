/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */

@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestDTO implements Serializable {

    public headerDataDTO getHeaderData() {
        return headerData;
    }

    public void setHeaderData(headerDataDTO headerData) {
        this.headerData = headerData;
    }
    
    public ExperienceDataDTO getExperienceData() {
        return experienceData;
    }

    public void setExperienceData(ExperienceDataDTO experienceData) {
        this.experienceData = experienceData;
    }
    
    public SkillsDataDTO getSkillsData() {
        return skillsData;
    }

    public void setSkillsData(SkillsDataDTO skillsData) {
        this.skillsData = skillsData;
    }
    
    private headerDataDTO headerData;
    
    private ExperienceDataDTO experienceData;
    
    private SkillsDataDTO skillsData;
    
    private long linkIndex;

    public long getLinkIndex() {
        return linkIndex;
    }

    public void setLinkIndex(long linkIndex) {
        this.linkIndex = linkIndex;
    }
}
