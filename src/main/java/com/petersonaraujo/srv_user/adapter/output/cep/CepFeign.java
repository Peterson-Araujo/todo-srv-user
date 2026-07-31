package com.petersonaraujo.srv_user.adapter.output.cep;

import com.petersonaraujo.srv_user.adapter.output.cep.dto.CepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "cep",
        url = "https://viacep.com.br/ws/"
)
public interface CepFeign {

    @GetMapping(value = "{cep}/json/")
    CepResponseDTO buscarCep(@PathVariable(value = "cep") String cep);
}
