package com.petersonaraujo.srv_user.adapter.output.cep;

import com.petersonaraujo.srv_user.adapter.output.cep.mapper.CepMapper;
import com.petersonaraujo.srv_user.domain.model.Cep;
import com.petersonaraujo.srv_user.ports.output.BuscarCepPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CepAdapter implements BuscarCepPort {

    private final CepFeign cepFeign;
    private final CepMapper cepMapper;

    @Override
    public Cep buscarCep(String cep) {
        if (cep.length() != 8 || !cep.matches("\\d+")) {
            throw new RuntimeException("CEP inválido (deve conter 8 dígitos numéricos e não pode conter letras ou caracteres especiais)");
        }

        return cepMapper.toModel(cepFeign.buscarCep(cep));
    }
}
