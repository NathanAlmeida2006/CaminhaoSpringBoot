package com.senai.transportadora.services.impls;

import com.senai.transportadora.dtos.funcionario.FuncionarioDTO;
import com.senai.transportadora.dtos.funcionario.FuncionarioDetailsDTO;
import com.senai.transportadora.dtos.funcionario.FuncionarioFormDTO;
import com.senai.transportadora.dtos.funcionario.UpdateFuncionarioFormDTO;
import com.senai.transportadora.models.Funcionario;
import com.senai.transportadora.repositories.FuncionarioRepository;
import com.senai.transportadora.services.interfaces.FuncionarioService;
import com.senai.transportadora.services.updaters.FuncionarioUpdater;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioUpdater funcionarioUpdater;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository, FuncionarioUpdater funcionarioUpdater) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioUpdater = funcionarioUpdater;
    }

    @Override
    public FuncionarioDTO criarFuncionario(FuncionarioFormDTO form) {
        Funcionario funcionario = form.toEntity();
        return new FuncionarioDTO(funcionarioRepository.save(funcionario));
    }

    @Override
    public List<FuncionarioDTO> listarFuncionarios() {
        return funcionarioRepository.findAll().stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }

    @Override
    public FuncionarioDetailsDTO buscarFuncionarioPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        return funcionario != null ? new FuncionarioDetailsDTO(funcionario) : null;
    }

    @Override
    public FuncionarioDTO atualizarFuncionario(Long id, UpdateFuncionarioFormDTO form) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(RuntimeException::new);
        funcionarioUpdater.atualizarFuncionario(funcionario, form);
        return new FuncionarioDTO(funcionarioRepository.save(funcionario));
    }

    @Override
    public void deletarFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
