package com.example.propertymanagement.service;

import com.example.propertymanagement.converter.UserConverter;
import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.entity.UserEntity;
import com.example.propertymanagement.exception.BusinessException;
import com.example.propertymanagement.exception.ErrorModel;
import com.example.propertymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<UserEntity> entityByEmail = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(entityByEmail.isEmpty()){
            UserEntity entity = userConverter.convertDtoToEntity(userDTO);
            entity = userRepository.save(entity);
            return userConverter.convertEntityToDto(entity);
        }
        List<ErrorModel> list = new ArrayList<>();
        ErrorModel error = new ErrorModel();
        error.setCode("INVALID_REGISTRATION");
        error.setMessage("User already exist!");
        list.add(error);
        throw new BusinessException(list);
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public UserDTO login(String userName, String password) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(userName, password);
        if(optionalUserEntity.isPresent()){
            return userConverter.convertEntityToDto(optionalUserEntity.get());
        }
        List<ErrorModel> list = new ArrayList<>();
        ErrorModel error = new ErrorModel();
        error.setCode("INVALID_LOGIN");
        error.setMessage("Invalid email or password");
        list.add(error);

        throw new BusinessException(list);
    }
}
