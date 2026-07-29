package com.petersonaraujo.srv_user.adapter.output.usuario.mapper;

import com.petersonaraujo.srv_user.adapter.output.usuario.entity.UsuarioEntity;
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
public interface UsuarioAdapterMapper {

    UsuarioAdapterMapper INSTANCE = Mappers.getMapper(UsuarioAdapterMapper.class);

    Usuario toModel(UsuarioEntity usuarioEntity);

    UsuarioEntity toEntity(Usuario usuario);

    List<Usuario> toModelList(List<UsuarioEntity> usuarioEntities);
}
