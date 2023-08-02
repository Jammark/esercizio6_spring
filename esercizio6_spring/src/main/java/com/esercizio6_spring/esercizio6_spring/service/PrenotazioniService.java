package com.esercizio6_spring.esercizio6_spring.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.esercizio6_spring.esercizio6_spring.model.Postazione;
import com.esercizio6_spring.esercizio6_spring.model.Prenotazione;
import com.esercizio6_spring.esercizio6_spring.model.User;

public class PrenotazioniService {

	@Autowired
	private UserService uServ;

	@Autowired
	private PostazioniService pServ;

	@Autowired
	private PrenotazioneRepository repo;

	public List<Prenotazione> prenotazioni() {
		return repo.findAll();
	}

	public void save(Prenotazione p) {
		if (isPostazioneOccupata(p) || isUserImpegnato(p) || !isValid(p)) {
			throw new IllegalArgumentException("Prenotazione non valida");
		} else {
			this.repo.save(p);
		}
	}

	public Prenotazione prenota(Long userId, Long postazioneId, LocalDate data) {
		User u = uServ.findById(userId).orElseThrow(() -> new IllegalArgumentException("Id utente non valido"));
		Postazione p = pServ.findById(postazioneId)
				.orElseThrow(() -> new IllegalArgumentException("Id postazione non valido"));
		Prenotazione pr = new Prenotazione(data, u, p);
		this.save(pr);
		return pr;
	}

	public boolean isPostazioneOccupata(Prenotazione p) {

		return repo.existsByPostazioneIdAndData(p.getPostazione().getId(), p.getData());
	}

	public boolean isUserImpegnato(Prenotazione p) {

		return repo.existsByUserIdAndData(p.getUser().getId(), p.getData());
	}

	public boolean isValid(Prenotazione p) {
		return p.getData().isAfter(LocalDate.now().plusDays(1));
	}

}
