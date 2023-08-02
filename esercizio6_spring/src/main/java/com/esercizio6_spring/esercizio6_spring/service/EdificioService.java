package com.esercizio6_spring.esercizio6_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio6_spring.esercizio6_spring.model.Edificio;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository repo;

	public Edificio save(Edificio e) {
		return repo.save(e);
	}

	public Edificio getById(Long id) {
		return this.repo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Nessuna corrispondenza per id: " + id));
	}

	public List<Edificio> getList() {
		return this.repo.findAll();
	}

	public boolean exists(Edificio e) {
		return this.repo.existsByNome(e.getNome());
	}
}
