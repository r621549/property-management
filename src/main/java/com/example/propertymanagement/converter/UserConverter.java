package com.example.propertymanagement.converter;

import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDtoToEntity(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setOwnerName(userDTO.getOwnerName());
        entity.setOwnerEmail(userDTO.getOwnerEmail());
        entity.setPhone(userDTO.getPhone());
        entity.setPassword(userDTO.getPassword());
        return entity;
    }

    public UserDTO convertEntityToDto(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setOwnerName(entity.getOwnerName());
        dto.setOwnerEmail(entity.getOwnerEmail());
        dto.setPhone(entity.getPhone());
        return dto;
    }
}
