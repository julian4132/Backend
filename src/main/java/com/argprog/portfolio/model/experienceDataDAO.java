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
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="item_data_id")
    private List<ItemDataDAO> experienceData=new ArrayList<ItemDataDAO>();
}
