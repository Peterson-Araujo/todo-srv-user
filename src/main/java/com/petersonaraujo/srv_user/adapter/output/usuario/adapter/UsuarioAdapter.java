package com.petersonaraujo.srv_user.adapter.output.usuario.adapter;


import com.petersonaraujo.srv_user.adapter.output.usuario.entity.UsuarioEntity;
import com.petersonaraujo.srv_user.adapter.output.usuario.mapper.UsuarioAdapterMapper;
import com.petersonaraujo.srv_user.adapter.output.usuario.repository.UsuarioRepository;
import com.petersonaraujo.srv_user.domain.entity.Usuario;
import com.petersonaraujo.srv_user.ports.output.DeletarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.EditarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.ProcurarUsuarioPort;
import com.petersonaraujo.srv_user.ports.output.SalvarUsuarioPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioAdapter implements SalvarUsuarioPort, EditarUsuarioPort, ProcurarUsuarioPort, DeletarUsuarioPort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioAdapterMapper mapper;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return mapper.toModel(usuarioRepository.save(mapper.toEntity(usuario)));
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario usuario) {
        buscarEntidade(id);

        usuario.setId(id);

        return mapper.toModel(usuarioRepository.save(mapper.toEntity(usuario)));
    }

    @Override
    public Usuario procurarUsuario(Long id) {
        return mapper.toModel(buscarEntidade(id));
    }

    @Override
    public void procurarUsuarioPorEmail(String email) {
        usuarioRepository.findByEmail(email)
                .ifPresent(usuarioEntity -> {
                    throw new RuntimeException("Usuário já cadastrado");
                });
    }

    @Override
    public List<Usuario> procurarTodosUsuarios() {
        return mapper.toModelList(usuarioRepository.findAll());
    }

    private UsuarioEntity buscarEntidade(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
