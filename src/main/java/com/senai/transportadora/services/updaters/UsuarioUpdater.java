package com.senai.transportadora.services.updaters;

import com.senai.transportadora.dtos.usuario.UpdateUsuarioFormDTO;
import com.senai.transportadora.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUpdater {

    public void atualizarUsuario(Usuario usuario, UpdateUsuarioFormDTO form) {
        if (form.nome() != null) usuario.setNome(form.nome());
        if (form.email() != null) usuario.setEmail(form.email());
        if (form.senha() != null) usuario.setSenha(form.senha());
        if (form.cargo() != null) usuario.setCargo(form.cargo());
    }
}
