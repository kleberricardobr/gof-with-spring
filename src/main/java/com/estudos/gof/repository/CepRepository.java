package com.estudos.gof.repository;

import com.estudos.gof.model.Cep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends CrudRepository<Cep, String> {
}
