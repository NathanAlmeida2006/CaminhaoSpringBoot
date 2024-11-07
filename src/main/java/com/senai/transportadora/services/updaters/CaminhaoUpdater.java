package com.senai.transportadora.services.updaters;

import com.senai.transportadora.dtos.caminhao.UpdateCaminhaoFormDTO;
import com.senai.transportadora.models.Caminhao;
import org.springframework.stereotype.Component;

@Component
public class CaminhaoUpdater {

    public void atualizarCaminhao(Caminhao caminhao, UpdateCaminhaoFormDTO form) {
        if (form.placa() != null) caminhao.setPlaca(form.placa());
        if (form.modelo() != null) caminhao.setModelo(form.modelo());
        if (form.cor() != null) caminhao.setCor(form.cor());
        if (form.fabricante() != null) caminhao.setFabricante(form.fabricante());
        if (form.numeroChassis() != null) caminhao.setNumeroChassis(form.numeroChassis());
        if (form.capacidadeCarga() != null) caminhao.setCapacidadeCarga(form.capacidadeCarga());
    }
}
