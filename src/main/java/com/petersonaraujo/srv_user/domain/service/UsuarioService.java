package com.petersonaraujo.srv_user.domain.service;

import com.petersonaraujo.srv_user.domain.entity.Usuario;
import com.petersonaraujo.srv_user.ports.input.DeletarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.EditarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.ProcurarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.SalvarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.output.DeletarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.EditarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.ProcurarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.SalvarUsuarioPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioService implements SalvarUsuarioUseCase, EditarUsuarioUseCase, ProcurarUsuarioUseCase, DeletarUsuarioUseCase {

    private final SalvarUsuarioPort salvarUsuarioPort;
    private final EditarUsuarioPort editarUsuarioPort;
    private final ProcurarUsuarioPort procurarUsuarioPort;
    private final DeletarUsuarioPort deletarUsuarioPort;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        procurarUsuarioPort.procurarUsuarioPorEmail(usuario.getEmail());

        return salvarUsuarioPort.salvarUsuario(usuario);
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario usuario) {
        Usuario usuarioExistente = getUsuario(id);

        if (!usuarioExistente.getEmail().equals(usuario.getEmail())) {
            procurarUsuarioPort.procurarUsuarioPorEmail(usuario.getEmail());
        }

        return editarUsuarioPort.editarUsuario(id, usuario);
    }

    @Override
    public Usuario procurarUsuario(Long id) {
        return procurarUsuarioPort.procurarUsuario(id);
    }

    @Override
    public void procurarUsuarioPorEmail(String email) {
        procurarUsuarioPort.procurarUsuarioPorEmail(email);
    }

    @Override
    public List<Usuario> procurarTodosUsuarios() {
        return procurarUsuarioPort.procurarTodosUsuarios();
    }

    @Override
    public void deletarUsuario(Long id) {
        getUsuario(id);
        deletarUsuarioPort.deletarUsuario(id);
    }

    private Usuario getUsuario(Long id) {
        return procurarUsuarioPort.procurarUsuario(id);
    }
}
