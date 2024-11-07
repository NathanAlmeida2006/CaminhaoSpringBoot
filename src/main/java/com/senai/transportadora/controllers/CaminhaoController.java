package com.senai.transportadora.controllers;

import com.senai.transportadora.dtos.caminhao.CaminhaoDTO;
import com.senai.transportadora.dtos.caminhao.CaminhaoDetailsDTO;
import com.senai.transportadora.dtos.caminhao.CaminhaoFormDTO;
import com.senai.transportadora.dtos.caminhao.UpdateCaminhaoFormDTO;
import com.senai.transportadora.services.interfaces.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/caminhoes")
@CrossOrigin(origins = "http://localhost:5173")
public class CaminhaoController {
    private final CaminhaoService caminhaoService;

    @Autowired
    public CaminhaoController(CaminhaoService caminhaoService) {
        this.caminhaoService = caminhaoService;
    }

    @PostMapping
    public ResponseEntity<CaminhaoDTO> cadastrarCaminhao(@RequestBody CaminhaoFormDTO caminhaoFormDTO) {
        CaminhaoDTO novocaminhaoDTO = caminhaoService.criarCaminhao(caminhaoFormDTO);
        return new ResponseEntity<>(novocaminhaoDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CaminhaoDTO>> listarCaminhao() {
        List<CaminhaoDTO> caminhaos = caminhaoService.listarCaminhaos();
        return new ResponseEntity<>(caminhaos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaminhaoDetailsDTO> buscarCaminhao(@PathVariable Long id) {
        CaminhaoDetailsDTO caminhao = caminhaoService.buscarCaminhaoPorId(id);
        return new ResponseEntity<>(caminhao, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaminhaoDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UpdateCaminhaoFormDTO updateForm) {
        CaminhaoDTO caminhaoAtulizado = caminhaoService.atualizarCaminhao(id, updateForm);
        return ResponseEntity.ok(caminhaoAtulizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaminhao(@PathVariable Long id) {
        caminhaoService.deletarCaminhao(id);
        return ResponseEntity.noContent().build();
    }
}
