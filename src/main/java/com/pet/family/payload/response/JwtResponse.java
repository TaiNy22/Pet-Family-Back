package com.pet.family.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Tainy
 */

@Getter
@Setter
public class JwtResponse {
    Long id;
    String token;
    String type = "Bearer";
    String username;
    String lastName;
    String name;

    Long phone;
    List<String> roles;

    public JwtResponse(String token, Long id, String username, String name, String lastName, Long phone, List<String> roles) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.roles = roles;
    }
}
