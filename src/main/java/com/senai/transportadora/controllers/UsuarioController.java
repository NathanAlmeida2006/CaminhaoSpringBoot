package com.senai.transportadora.controllers;

import com.senai.transportadora.dtos.usuario.UpdateUsuarioFormDTO;
import com.senai.transportadora.dtos.usuario.UsuarioDTO;
import com.senai.transportadora.dtos.usuario.UsuarioDetailsDTO;
import com.senai.transportadora.dtos.usuario.UsuarioFormDTO;
import com.senai.transportadora.services.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioFormDTO usuarioFormDTO) {
        UsuarioDTO novoUsuarioDTO = usuarioService.criarUsuario(usuarioFormDTO);
        return new ResponseEntity<>(novoUsuarioDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetailsDTO> buscarUsuario(@PathVariable Long id) {
        UsuarioDetailsDTO usuario = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UpdateUsuarioFormDTO updateForm) {
        UsuarioDTO usuarioAtualizado = usuarioService.atualizarUsuario(id, updateForm);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
