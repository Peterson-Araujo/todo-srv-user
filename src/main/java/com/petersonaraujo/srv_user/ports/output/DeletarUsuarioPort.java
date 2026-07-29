package com.petersonaraujo.srv_user.ports.output;

import com.petersonaraujo.srv_user.domain.entity.Usuario;

/**
 * Caso de uso excluir um usuário {@link Usuario}
 */
public interface DeletarUsuarioPort {

    /**
     * Exclui um usuário cadastrado, retornando o usuário excluído com sucesso
     * @param id -> id do usuário a ser excluído
     * @return {@link Usuario}
     */
    void deletarUsuario (Long id);
}
