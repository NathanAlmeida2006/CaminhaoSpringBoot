package com.senai.transportadora.services.interfaces;

import com.senai.transportadora.dtos.usuario.auth.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authenticate(LoginRequest loginRequest);
}
