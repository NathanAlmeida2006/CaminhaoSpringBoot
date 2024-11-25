package com.senai.transportadora.services.impls;

import com.senai.transportadora.dtos.usuario.auth.LoginRequest;
import com.senai.transportadora.repositories.UsuarioRepository;
import com.senai.transportadora.services.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> authenticate(LoginRequest loginRequest) {
        return usuarioRepository.findByEmail(loginRequest.getEmail()).filter(user -> passwordEncoder.matches(loginRequest.getSenha(), user.getSenha())).map(user -> {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("email", user.getEmail());
            return ResponseEntity.ok().body(response);
        }).orElse(ResponseEntity.badRequest().body(Map.of("message", "Invalid credentials")));
    }
}
