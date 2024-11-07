package com.senai.transportadora.services.interfaces;

import com.senai.transportadora.dtos.funcionario.FuncionarioDTO;
import com.senai.transportadora.dtos.funcionario.FuncionarioDetailsDTO;
import com.senai.transportadora.dtos.funcionario.FuncionarioFormDTO;
import com.senai.transportadora.dtos.funcionario.UpdateFuncionarioFormDTO;

import java.util.List;

public interface FuncionarioService {
    FuncionarioDTO criarFuncionario(FuncionarioFormDTO FuncionarioFormDTO);

    List<FuncionarioDTO> listarFuncionarios();

    FuncionarioDetailsDTO buscarFuncionarioPorId(Long id);

    FuncionarioDTO atualizarFuncionario(Long id, UpdateFuncionarioFormDTO form);

    void deletarFuncionario(Long id);
}
