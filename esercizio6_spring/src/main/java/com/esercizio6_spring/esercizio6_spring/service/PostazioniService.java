package com.esercizio6_spring.esercizio6_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio6_spring.esercizio6_spring.model.Postazione;
import com.esercizio6_spring.esercizio6_spring.model.TipoPostazione;

@Service
public class PostazioniService {

	@Autowired
	private PostazioneRepository repo;



	public List<Postazione> postazioni() {
		return this.repo.findAll();
	}

	public List<Postazione> postazioni(TipoPostazione tipo, String città) {
		return this.repo.findByTipoAndEdificioCittà(tipo, città);
	}

	public Optional<Postazione> findById(Long id) {
		return this.repo.findById(id);
	}

	public Postazione save(Postazione p) {
		return this.repo.save(p);
	}
}
