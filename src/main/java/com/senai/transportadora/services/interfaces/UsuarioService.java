package com.senai.transportadora.services.interfaces;

import com.senai.transportadora.dtos.usuario.UsuarioDTO;
import com.senai.transportadora.dtos.usuario.UsuarioDetailsDTO;
import com.senai.transportadora.dtos.usuario.UsuarioFormDTO;
import com.senai.transportadora.dtos.usuario.UpdateUsuarioFormDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO criarUsuario(UsuarioFormDTO form);

    List<UsuarioDTO> listarUsuarios();

    UsuarioDetailsDTO buscarUsuarioPorId(Long id);

    UsuarioDTO atualizarUsuario(Long id, UpdateUsuarioFormDTO form);

    void deletarUsuario(Long id);
}
