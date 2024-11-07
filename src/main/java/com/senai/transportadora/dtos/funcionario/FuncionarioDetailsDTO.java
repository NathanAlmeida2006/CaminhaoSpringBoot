package com.senai.transportadora.dtos.funcionario;

import com.senai.transportadora.models.Funcionario;

import java.util.Date;

public record FuncionarioDetailsDTO(Long id, String nome, String cpf, String rg, Date dataNascimento, String cargo,
                                    String email, String telefone, Date dataCadastro) {
    public FuncionarioDetailsDTO(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getRg(), funcionario.getDataNascimento(), funcionario.getCargo(),
                funcionario.getEmail(), funcionario.getTelefone(), funcionario.getDataCadastro());
    }
}
