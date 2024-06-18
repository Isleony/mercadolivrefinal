package com.mercadolivre.bootcamp.demo.repository;

import com.mercadolivre.bootcamp.demo.model.ClubeModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClubeRepository extends CrudRepository<ClubeModel, Integer> {
    Optional<ClubeModel> findByNome(String nome);
}
