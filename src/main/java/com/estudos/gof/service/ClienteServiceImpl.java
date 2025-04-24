package com.estudos.gof.service;

import com.estudos.gof.model.Cliente;
import com.estudos.gof.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public boolean cpfAlreadyUsed(String cpf) {
        var cliente = clienteRepository.findByCpf(cpf);
        System.out.println(cliente);
       return cliente != null;
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
