package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author Tainy
 */
@Getter
@Setter
public class SignupRequest {
    @NotBlank
    private String username;

    private Set<String> role;

    @NotBlank
    private String password;

    private String name;

    private String lastname;

    private Long phone;

    private String email;

    private String city;
}
