package com.senai.transportadora.services.impls;

import com.senai.transportadora.dtos.usuario.UpdateUsuarioFormDTO;
import com.senai.transportadora.dtos.usuario.UsuarioDTO;
import com.senai.transportadora.dtos.usuario.UsuarioDetailsDTO;
import com.senai.transportadora.dtos.usuario.UsuarioFormDTO;
import com.senai.transportadora.models.Usuario;
import com.senai.transportadora.repositories.UsuarioRepository;
import com.senai.transportadora.services.interfaces.UsuarioService;
import com.senai.transportadora.services.updaters.UsuarioUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioUpdater usuarioUpdater;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioUpdater usuarioUpdater) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioUpdater = usuarioUpdater;
    }

    @Override
    public UsuarioDTO criarUsuario(UsuarioFormDTO form) {
        Usuario usuario = form.toEntity();
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioDetailsDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuario != null ? new UsuarioDetailsDTO(usuario) : null;
    }

    @Override
    public UsuarioDTO atualizarUsuario(Long id, UpdateUsuarioFormDTO form) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuarioUpdater.atualizarUsuario(usuario, form);
        return new UsuarioDTO(usuarioRepository.save(usuario));
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
