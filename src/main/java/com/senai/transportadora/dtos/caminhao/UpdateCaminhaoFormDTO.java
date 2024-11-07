package com.senai.transportadora.dtos.caminhao;

public record UpdateCaminhaoFormDTO(String placa, String modelo, String cor, String fabricante, String numeroChassis,
                                    Double capacidadeCarga) {
}
