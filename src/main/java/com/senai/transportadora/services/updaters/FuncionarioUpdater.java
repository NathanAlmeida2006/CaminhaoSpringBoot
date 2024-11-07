package com.senai.transportadora.services.updaters;

import com.senai.transportadora.dtos.caminhao.UpdateCaminhaoFormDTO;
import com.senai.transportadora.dtos.funcionario.UpdateFuncionarioFormDTO;
import com.senai.transportadora.models.Caminhao;
import com.senai.transportadora.models.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioUpdater {

    public void atualizarFuncionario(Funcionario funcionario, UpdateFuncionarioFormDTO form) {
        if(form.nome() != null) funcionario.setNome(form.nome());
        if (form.cpf() != null) funcionario.setCpf(form.cpf());
        if (form.rg() != null) funcionario.setRg(form.rg());
        if (form.dataCadastro() != null) funcionario.setDataCadastro(form.dataCadastro());
        if (form.email() != null) funcionario.setEmail(form.email());
        if(form.telefone() != null) funcionario.setTelefone(form.telefone());
        if(form.dataCadastro() != null) funcionario.setDataCadastro(form.dataCadastro());
    }
}
