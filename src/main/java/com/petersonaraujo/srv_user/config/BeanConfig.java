package com.petersonaraujo.srv_user.config;

import com.petersonaraujo.srv_user.domain.service.UsuarioService;
import com.petersonaraujo.srv_user.ports.output.DeletarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.EditarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.ProcurarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.SalvarUsuarioPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UsuarioService usuarioService(
            SalvarUsuarioPort salvarUsuarioPort,
            EditarUsuarioPort editarUsuarioPort,
            ProcurarUsuarioPort procurarUsuarioPort,
            DeletarUsuarioPort deletarUsuarioPort) {
        return new UsuarioService(salvarUsuarioPort, editarUsuarioPort, procurarUsuarioPort, deletarUsuarioPort);
    }
}
