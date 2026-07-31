package com.petersonaraujo.srv_user.adapter.input.usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

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
