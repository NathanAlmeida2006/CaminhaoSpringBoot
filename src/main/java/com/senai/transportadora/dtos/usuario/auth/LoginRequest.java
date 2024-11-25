package com.senai.transportadora.dtos.usuario.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String senha;

}
