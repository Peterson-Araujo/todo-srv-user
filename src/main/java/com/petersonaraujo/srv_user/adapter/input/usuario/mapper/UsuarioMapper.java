package com.petersonaraujo.srv_user.adapter.input.usuario.mapper;

import com.petersonaraujo.srv_user.adapter.input.usuario.dto.UsuarioRequest;
import com.petersonaraujo.srv_user.adapter.input.usuario.dto.UsuarioResponse;
import com.petersonaraujo.srv_user.domain.entity.Usuario;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        builder = @Builder(disableBuilder = true)
)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioResponse toResponse(Usuario usuario);

    Usuario toModel(UsuarioRequest usuarioRequest);

    List<UsuarioResponse> toResponseList(List<Usuario> usuarios);
}
