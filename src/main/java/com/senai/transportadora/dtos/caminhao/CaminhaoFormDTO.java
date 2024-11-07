package com.senai.transportadora.dtos.caminhao;

import com.senai.transportadora.models.Caminhao;

public record CaminhaoFormDTO(String placa, String modelo, String cor, String fabricante, String numeroChassis,
                              Double capacidadeCarga) {
    public Caminhao toEntity() {
        return new Caminhao(null, placa, modelo, cor, fabricante, numeroChassis, capacidadeCarga);
    }
}
