package com.petersonaraujo.srv_user.adapter.output.cep.mapper;

import com.petersonaraujo.srv_user.adapter.output.cep.dto.CepRequestDTO;
import com.petersonaraujo.srv_user.adapter.output.cep.dto.CepResponseDTO;
import com.petersonaraujo.srv_user.domain.model.Cep;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        builder = @Builder(disableBuilder = true)
)
public interface CepMapper {

    CepMapper INSTANCE = Mappers.getMapper(CepMapper.class);

    Cep toModel(CepResponseDTO cepResponseDTO);

    CepRequestDTO toRequestDTO(String cep);
}
