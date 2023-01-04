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
    String apellido;
    String nombre;
    List<String> roles;

    public JwtResponse(String token, Long id, String username, String nombre, String apellido, List<String> roles) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.roles = roles;
    }
}
