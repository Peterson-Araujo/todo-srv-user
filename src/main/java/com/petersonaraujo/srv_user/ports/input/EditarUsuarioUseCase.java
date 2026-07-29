package com.petersonaraujo.srv_user.ports.input;

import com.petersonaraujo.srv_user.domain.entity.Usuario;

/**
 * Caso de uso para editar um usuário {@link Usuario}
 */
public interface EditarUsuarioUseCase {

    /**
     * Edita um usuário cadastrado, retornando o usuário editado com sucesso
     * @param id -> id do usuário a ser editado
     * @param usuario -> usuário com os dados a serem editados
     * @return {@link Usuario}
     */
    Usuario editarUsuario (Long id, Usuario usuario);
}
