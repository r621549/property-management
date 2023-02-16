package com.example.propertymanagement.converter;

import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyConverter {
    public PropertyEntity convertDtoToEntity(PropertyDTO propertyDTO){
        PropertyEntity entity = new PropertyEntity();
        entity.setTitle(propertyDTO.getTitle());
        entity.setDescription(propertyDTO.getDescription());
        entity.setOwnerName(propertyDTO.getOwnerName());
        entity.setOwnerEmail(propertyDTO.getOwnerEmail());
        entity.setPrice(propertyDTO.getPrice());
        entity.setAddress(propertyDTO.getAddress());
        return entity;
    }

    public PropertyDTO convertEntityToDto(PropertyEntity entity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(entity.getId());
        propertyDTO.setTitle(entity.getTitle());
        propertyDTO.setDescription(entity.getDescription());
        propertyDTO.setOwnerName(entity.getOwnerName());
        propertyDTO.setOwnerEmail(entity.getOwnerEmail());
        propertyDTO.setPrice(entity.getPrice());
        propertyDTO.setAddress(entity.getAddress());
        return propertyDTO;
    }

    public List<PropertyDTO> convertEntitiesToDtos(List<PropertyEntity> entities) {
        List<PropertyDTO> dtos = new ArrayList<>();
        for(PropertyEntity entity : entities){
            dtos.add(convertEntityToDto(entity));
        }
        return dtos;
    }
}
