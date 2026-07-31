package com.petersonaraujo.srv_user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String cep;
    private String cidade;
    private String bairro;
    private String estado;
}
