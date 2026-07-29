package com.petersonaraujo.srv_user.ports.output;

import com.petersonaraujo.srv_user.domain.entity.Usuario;

/**
 * Caso de uso para salvar um usuário {@link Usuario}
 */
public interface SalvarUsuarioPort {

    /**
     * Salva um usuário, retornando o usuário salvo com sucesso
     * @param usuario
     * @return {@link Usuario}
     */
    Usuario salvarUsuario (Usuario usuario);
}
