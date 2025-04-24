package com.estudos.gof.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    @NotBlank(message = "{campo.notblank}")
    @Size(max = 500)
    private String nome;

    @NotBlank(message = "{campo.notblank}")
    @Size(max = 150, message = "{campo.maxsize}")
    private String telefone;

    @NotBlank(message = "{campo.notblank}")
    @Size(max = 15, message = "{campo.maxsize}")
    private String cpf;

    @NotBlank(message = "{campo.notblank}")
    private String cep;
}
