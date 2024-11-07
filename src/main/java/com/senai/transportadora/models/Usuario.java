package com.senai.transportadora.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
}
