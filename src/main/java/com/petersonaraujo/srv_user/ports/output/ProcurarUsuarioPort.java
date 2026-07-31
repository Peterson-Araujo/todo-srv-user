package com.petersonaraujo.srv_user.ports.output;

import com.petersonaraujo.srv_user.domain.model.Usuario;

import java.util.List;

/**
 * Caso de uso para procurar um usuário {@link Usuario}
 */
public interface ProcurarUsuarioPort {

    /**
     * Busca um usuário cadastrado, retornando o usuário encontrado com sucesso
     * @param id -> id do usuário a ser procurado
     * @return {@link Usuario}
     */
    Usuario procurarUsuario(Long id);
    void procurarUsuarioPorEmail(String email);
    List<Usuario> procurarTodosUsuarios();
}
