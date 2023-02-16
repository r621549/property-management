package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> saveProperty(@RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.register(userDTO), HttpStatus.CREATED);
    }

}