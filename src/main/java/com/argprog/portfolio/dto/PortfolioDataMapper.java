/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.portfolio.dto;

import com.argprog.portfolio.model.PortfolioUserDataDAO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
/**
 *
 * @author Usuario
 */
@Mapper(componentModel = "spring")
public interface PortfolioDataMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePortfolioDataFromDto(UpdateRequestDTO dto, @MappingTarget PortfolioUserDataDAO entity);
}
