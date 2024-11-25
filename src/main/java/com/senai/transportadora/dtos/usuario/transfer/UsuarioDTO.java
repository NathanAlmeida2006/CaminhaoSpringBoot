package com.senai.transportadora.dtos.usuario.transfer;

import com.senai.transportadora.models.Usuario;

public record UsuarioDTO(Long id, String nome, String email, String senha, String cargo) {
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getCargo());
    }
}
