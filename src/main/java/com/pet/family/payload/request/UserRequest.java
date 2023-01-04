package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Tainy
 */
@Getter
@Setter
public class UserRequest {
    @NotBlank
    private String username;

    private String role;

    @NotBlank
    private String password;

    private String name;

    private String lastname;

    private Long phone;

    private String email;

    private String city;
}