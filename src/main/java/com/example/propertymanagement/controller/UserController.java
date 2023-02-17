package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.UserDTO;
import com.example.propertymanagement.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "register", notes = "This method is used for registration of user")
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(
            @ApiParam(name = "user", type = "userDTO", example = "user information", required = true
            ) @Valid @RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.CREATED);
    }

    @PostMapping(path = "/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.login(userDTO.getOwnerEmail(), userDTO.getPassword()), HttpStatus.OK);
    }

}
