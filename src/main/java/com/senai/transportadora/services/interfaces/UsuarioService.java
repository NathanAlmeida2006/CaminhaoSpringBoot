package com.senai.transportadora.services.interfaces;

import com.senai.transportadora.dtos.usuario.transfer.UsuarioDTO;
import com.senai.transportadora.dtos.usuario.transfer.UsuarioDetailsDTO;
import com.senai.transportadora.dtos.usuario.transfer.UsuarioFormDTO;
import com.senai.transportadora.dtos.usuario.transfer.UpdateUsuarioFormDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO criarUsuario(UsuarioFormDTO form);

    List<UsuarioDTO> listarUsuarios();

    UsuarioDetailsDTO buscarUsuarioPorId(Long id);

    UsuarioDTO atualizarUsuario(Long id, UpdateUsuarioFormDTO form);

    void deletarUsuario(Long id);
}
