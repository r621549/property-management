package com.example.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "Owner email is mandatory!")
    @NotEmpty(message = "Owner email is mandatory!")
    @Size(min = 1, max = 50, message = "Owner email must be between 1 and 50 chars")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password is mandatory!")
    @NotEmpty(message = "Password is mandatory!")
    private String password;
}
