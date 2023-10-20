package com.viu.moduloautenticacion.security.model;

import com.viu.moduloautenticacion.Parqueadero.model.Parking;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {


    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @Email
    private String email;

    private Parking parking;

    private String rol;
}
