package com.estudos.gof.repository;

import com.estudos.gof.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public Cliente findByCpf(String cpf);
}
