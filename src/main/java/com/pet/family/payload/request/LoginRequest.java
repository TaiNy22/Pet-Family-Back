package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tainy
 */
@Getter
@Setter
public class LoginRequest {
    String username;

    String password;
}
