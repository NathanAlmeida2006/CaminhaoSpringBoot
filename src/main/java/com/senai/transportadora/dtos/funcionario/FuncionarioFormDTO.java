package com.senai.transportadora.dtos.funcionario;

import com.senai.transportadora.models.Funcionario;

import java.util.Date;

public record FuncionarioFormDTO(String nome, String cpf, String rg, Date dataNascimento, String cargo, String email,
                                 String telefone, Date dataCadastro) {

    public Funcionario toEntity() {
        return new Funcionario(null, nome, cpf, rg, dataNascimento, cargo, email, telefone, dataCadastro);
    }
}
