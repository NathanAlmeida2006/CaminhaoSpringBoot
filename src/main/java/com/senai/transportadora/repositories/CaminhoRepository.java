package com.senai.transportadora.repositories;

import com.senai.transportadora.models.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhoRepository extends JpaRepository <Caminhao, Long> {
}
