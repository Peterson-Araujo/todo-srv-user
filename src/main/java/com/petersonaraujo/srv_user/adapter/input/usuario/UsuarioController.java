package com.petersonaraujo.srv_user.adapter.input.usuario;

import com.petersonaraujo.srv_user.adapter.input.usuario.dto.UsuarioRequest;
import com.petersonaraujo.srv_user.adapter.input.usuario.dto.UsuarioResponse;
import com.petersonaraujo.srv_user.adapter.input.usuario.mapper.UsuarioMapper;
import com.petersonaraujo.srv_user.ports.input.DeletarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.EditarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.ProcurarUsuarioUseCase;
import com.petersonaraujo.srv_user.ports.input.SalvarUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

    private final SalvarUsuarioUseCase salvarUsuarioUseCase;
    private final EditarUsuarioUseCase editarUsuarioUseCase;
    private final ProcurarUsuarioUseCase procurarUsuarioUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final UsuarioMapper mapper;

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioResponse> salvarUsuario(@RequestBody UsuarioRequest usuarioRequest) {

        var usuarioSalvo = salvarUsuarioUseCase.salvarUsuario(mapper.toModel(usuarioRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(usuarioSalvo));
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<UsuarioResponse> editarUsuario(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) {

        var usuarioEditado = editarUsuarioUseCase.editarUsuario(id, mapper.toModel(usuarioRequest));
        return ResponseEntity.ok().body(mapper.toResponse(usuarioEditado));
    }

    @GetMapping("/procurar/{id}")
    public ResponseEntity<UsuarioResponse> procurarUsuario(@PathVariable Long id) {
        var usuarioProcurado = procurarUsuarioUseCase.procurarUsuario(id);
        return ResponseEntity.ok().body(mapper.toResponse(usuarioProcurado));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> procurarTodosUsuarios() {
        var usuarios = procurarUsuarioUseCase.procurarTodosUsuarios();
        return ResponseEntity.ok().body(mapper.toResponseList(usuarios));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        deletarUsuarioUseCase.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
