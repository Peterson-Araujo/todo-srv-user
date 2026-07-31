package com.petersonaraujo.srv_user.domain.service;

import com.petersonaraujo.srv_user.domain.model.Usuario;
import com.petersonaraujo.srv_user.ports.input.DeletarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.EditarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.ProcurarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.SalvarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.output.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioService implements SalvarUsuarioUseCase, EditarUsuarioUseCase, ProcurarUsuarioUseCase, DeletarUsuarioUseCase {

    private final SalvarUsuarioPort salvarUsuarioPort;
    private final EditarUsuarioPort editarUsuarioPort;
    private final ProcurarUsuarioPort procurarUsuarioPort;
    private final DeletarUsuarioPort deletarUsuarioPort;
    private final BuscarCepPort buscarCepPort;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        procurarUsuarioPort.procurarUsuarioPorEmail(usuario.getEmail());

        var cepEncontrado = buscarCepPort.buscarCep(usuario.getCep());
        usuario.setBairro(cepEncontrado.getBairro());
        usuario.setCidade(cepEncontrado.getLocalidade());
        usuario.setEstado(cepEncontrado.getUf());

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
