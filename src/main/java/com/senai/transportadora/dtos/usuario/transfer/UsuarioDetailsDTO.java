package com.senai.transportadora.dtos.usuario;

import com.senai.transportadora.models.Usuario;

public record UsuarioDetailsDTO(Long id, String nome, String email, String senha, String cargo) {
    public UsuarioDetailsDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getCargo());
    }
}
