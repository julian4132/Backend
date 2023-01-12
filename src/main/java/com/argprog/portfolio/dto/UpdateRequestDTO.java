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
    private headerDataDTO headerData;
}
