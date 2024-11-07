package com.senai.transportadora.controllers;

import com.senai.transportadora.dtos.funcionario.FuncionarioDTO;
import com.senai.transportadora.dtos.funcionario.FuncionarioDetailsDTO;
import com.senai.transportadora.dtos.funcionario.FuncionarioFormDTO;
import com.senai.transportadora.dtos.funcionario.UpdateFuncionarioFormDTO;
import com.senai.transportadora.services.interfaces.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/funcionarios")
@CrossOrigin(origins = "http://localhost:5173")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioRepository) {
        this.funcionarioService = funcionarioRepository;
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> cadastrarFuncionario(@RequestBody FuncionarioFormDTO funcionarioFormDTO) {
        FuncionarioDTO novoFuncionarioDTO = funcionarioService.criarFuncionario(funcionarioFormDTO);
        return new ResponseEntity<>(novoFuncionarioDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionarioService.listarFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDetailsDTO> buscarFuncionarioPorId(@PathVariable Long id) {
        FuncionarioDetailsDTO funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> atualizarFuncionario(@PathVariable Long id, @RequestBody UpdateFuncionarioFormDTO updateForm) {
        FuncionarioDTO funcionarioAtulizado = funcionarioService.atualizarFuncionario(id, updateForm);
        return ResponseEntity.ok(funcionarioAtulizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
