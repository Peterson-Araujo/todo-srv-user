package com.petersonaraujo.srv_user.adapter.exception.handler;

import com.petersonaraujo.srv_user.adapter.exception.handler.erro.ErroResponse;
import com.petersonaraujo.srv_user.domain.exception.BusinessException;
import com.petersonaraujo.srv_user.domain.exception.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErroResponse> businessException(BusinessException ex) {

        ErroResponse erro = new ErroResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
