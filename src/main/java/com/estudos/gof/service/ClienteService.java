package com.estudos.gof.service;

import com.estudos.gof.model.Cliente;

import java.util.Optional;

public interface ClienteService {
    public Iterable<Cliente> getClientes();

    public Optional<Cliente> getCliente(Long id);

    public boolean cpfAlreadyUsed(String cpf);

    public Cliente saveCliente(Cliente cliente);
}
