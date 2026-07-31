package com.petersonaraujo.srv_user.adapter.exception.handler.erro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {

    Integer status;
    String mensagem;
}
