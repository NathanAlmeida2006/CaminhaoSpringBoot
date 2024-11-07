package com.senai.transportadora.services.interfaces;

import com.senai.transportadora.dtos.caminhao.CaminhaoDTO;
import com.senai.transportadora.dtos.caminhao.CaminhaoDetailsDTO;
import com.senai.transportadora.dtos.caminhao.CaminhaoFormDTO;
import com.senai.transportadora.dtos.caminhao.UpdateCaminhaoFormDTO;

import java.util.List;

public interface CaminhaoService {
    CaminhaoDTO criarCaminhao(CaminhaoFormDTO caminhaoFormDTO);

    List<CaminhaoDTO> listarCaminhaos();

    CaminhaoDetailsDTO buscarCaminhaoPorId(Long id);

    CaminhaoDTO atualizarCaminhao(Long id, UpdateCaminhaoFormDTO form);

    void deletarCaminhao(Long id);
}
