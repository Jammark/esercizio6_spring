package com.esercizio6_spring.esercizio6_spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio6_spring.esercizio6_spring.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

	boolean existsByNome(String nome);

}
