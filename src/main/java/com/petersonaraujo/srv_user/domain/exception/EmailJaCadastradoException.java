package com.petersonaraujo.srv_user.domain.exception;

import org.springframework.http.HttpStatus;

public class EmailJaCadastradoException extends BusinessException {

    public EmailJaCadastradoException() {
        super(HttpStatus.CONFLICT, "E-mail já cadastrado!");
    }
}
