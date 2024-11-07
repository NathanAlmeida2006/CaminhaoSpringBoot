package com.senai.transportadora.dtos.funcionario;

import java.util.Date;

public record UpdateFuncionarioFormDTO(String nome, String cpf, String rg, Date dataNascimento, String cargo,
                                       String email, String telefone, Date dataCadastro) {
}
