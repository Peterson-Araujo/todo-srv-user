package com.petersonaraujo.srv_user.domain.exception;

import org.springframework.http.HttpStatus;

public class UsuarioNaoEncontradoException extends BusinessException {
    public UsuarioNaoEncontradoException() {
        super(HttpStatus.NOT_FOUND, "Usuário não encontrado!");
    }
}
