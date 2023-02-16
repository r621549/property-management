package com.example.propertymanagement.service;

import com.example.propertymanagement.converter.UserConverter;
import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entity.UserEntity;
import com.example.propertymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    /**
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity entity = userConverter.convertDtoToEntity(userDTO);
        entity = userRepository.save(entity);
        return userConverter.convertEntityToDto(entity);
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public UserDTO login(String userName, String password) {
        return null;
    }
}
