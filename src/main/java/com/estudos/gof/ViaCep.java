package com.estudos.gof;

import com.estudos.gof.model.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCep {
    @GetMapping(value = "{cep}/json")
    public Cep getCep(@PathVariable("cep") String cep);
}
