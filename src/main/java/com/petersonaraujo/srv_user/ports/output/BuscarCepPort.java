package com.petersonaraujo.srv_user.ports.output;

import com.petersonaraujo.srv_user.domain.model.Cep;
import com.petersonaraujo.srv_user.domain.model.Usuario;

/**
 * Caso de uso para buscar um endereço de usuário
 */
public interface BuscarCepPort {

    Cep buscarCep(String cep);
}
