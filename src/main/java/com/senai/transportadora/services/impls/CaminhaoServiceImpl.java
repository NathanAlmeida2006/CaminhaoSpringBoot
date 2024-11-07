package com.senai.transportadora.services.impls;

import com.senai.transportadora.dtos.caminhao.CaminhaoDTO;
import com.senai.transportadora.dtos.caminhao.CaminhaoDetailsDTO;
import com.senai.transportadora.dtos.caminhao.CaminhaoFormDTO;
import com.senai.transportadora.dtos.caminhao.UpdateCaminhaoFormDTO;
import com.senai.transportadora.models.Caminhao;
import com.senai.transportadora.repositories.CaminhoRepository;
import com.senai.transportadora.services.interfaces.CaminhaoService;
import com.senai.transportadora.services.updaters.CaminhaoUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaminhaoServiceImpl implements CaminhaoService {
    private final CaminhoRepository caminhoRepository;
    private final CaminhaoUpdater caminhaoUpdater;

    @Autowired
    public CaminhaoServiceImpl(CaminhoRepository caminhoRepository, CaminhaoUpdater caminhaoUpdater) {
        this.caminhoRepository = caminhoRepository;
        this.caminhaoUpdater = caminhaoUpdater;
    }

    @Override
    public CaminhaoDTO criarCaminhao(CaminhaoFormDTO caminhaoFormDTO) {
        Caminhao caminhao = caminhaoFormDTO.toEntity();
        return new CaminhaoDTO(caminhoRepository.save(caminhao));
    }

    @Override
    public List<CaminhaoDTO> listarCaminhaos() {
        return caminhoRepository.findAll().stream().map(CaminhaoDTO::new).collect(Collectors.toList());
    }

    @Override
    public CaminhaoDetailsDTO buscarCaminhaoPorId(Long id) {
        Caminhao caminhao = caminhoRepository.findById(id).orElse(null);
        return caminhao != null ? new CaminhaoDetailsDTO(caminhao) : null;
    }

    @Override
    public CaminhaoDTO atualizarCaminhao(Long id, UpdateCaminhaoFormDTO form) {
        Caminhao caminhao = caminhoRepository.findById(id).orElseThrow(RuntimeException::new);
        caminhaoUpdater.atualizarCaminhao(caminhao, form);
        return new CaminhaoDTO(caminhoRepository.save(caminhao));
    }

    @Override
    public void deletarCaminhao(Long id) {
        caminhoRepository.deleteById(id);
    }
}
