package com.senai.transportadora.dtos.usuario;

import com.senai.transportadora.models.Usuario;

public record UsuarioFormDTO(String nome, String email, String senha, String cargo) {
    public Usuario toEntity() {
        return new Usuario(null, nome, email, senha, cargo);
    }
}
