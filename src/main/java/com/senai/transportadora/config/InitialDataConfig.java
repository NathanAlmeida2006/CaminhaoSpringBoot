package com.senai.transportadora.config;

import com.senai.transportadora.models.Usuario;
import com.senai.transportadora.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InitialDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepository.count() == 0) {
                Usuario admin = new Usuario();
                admin.setEmail("admin@example.com");
                admin.setSenha(passwordEncoder.encode("admin123"));
                usuarioRepository.save(admin);
            }
        };
    }
}
