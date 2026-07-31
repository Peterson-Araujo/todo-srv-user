package com.petersonaraujo.srv_user.adapter.output.usuario.repository;

import com.petersonaraujo.srv_user.adapter.output.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}
