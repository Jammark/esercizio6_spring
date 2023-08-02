package com.esercizio6_spring.esercizio6_spring.endpoints;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esercizio6_spring.esercizio6_spring.model.Edificio;
import com.esercizio6_spring.esercizio6_spring.model.Postazione;
import com.esercizio6_spring.esercizio6_spring.model.Prenotazione;
import com.esercizio6_spring.esercizio6_spring.model.TipoPostazione;
import com.esercizio6_spring.esercizio6_spring.model.User;
import com.esercizio6_spring.esercizio6_spring.service.EdificioService;
import com.esercizio6_spring.esercizio6_spring.service.PostazioniService;
import com.esercizio6_spring.esercizio6_spring.service.PrenotazioniService;
import com.esercizio6_spring.esercizio6_spring.service.UserService;

@RestController
@RequestMapping("/gestione_prenotazioni")
public class AppController {

	@Autowired
	private EdificioService eServ;

	@Autowired
	private PrenotazioniService pService;
	@Autowired
	private PostazioniService posService;
	@Autowired
	private UserService uService;

	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUtenti() {
		return this.uService.findAll();
	}

	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponsePayload create(@RequestBody UserUpdatePayload body) {
		User u = new User(body.getUsername(), body.getNomeCompleto(), body.getEmail());
		u = uService.save(u);
		return new UserResponsePayload(u.getId(), u.getUsername(), u.getNomeCompleto(), u.getEmail());
	}

	@GetMapping("/postazioni")
	@ResponseStatus(HttpStatus.OK)
	public List<Postazione> getPostazioni() {
		return this.posService.postazioni();
	}

	@PostMapping("/postazioni")
	@ResponseStatus(HttpStatus.CREATED)
	public PostazioneResponsePayload create(@RequestBody PostazioneUpdatePayload body) {
		Postazione p = new Postazione(body.getDescrizione(), body.getTipo(), body.getMaxOccupanti());
		Edificio e = eServ.getById(body.getEdificiorId());
		p.setEdificio(e);
		Postazione ps = posService.save(p);
		return new PostazioneResponsePayload(ps.getId(), ps.getEdificio().getId(), ps.getDescrizione(), ps.getTipo(),
				ps.getMaxOccupanti());
	}

	@SuppressWarnings("rawtypes")
	@GetMapping("/postazioni")
	public ResponseEntity getPostazioni(@RequestParam String tipo, @RequestParam String città) {
		try {
			List<Postazione> lista = this.posService.postazioni(TipoPostazione.valueOf(tipo), città);
			return new ResponseEntity<List<Postazione>>(lista, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/prenotazioni")
	public ResponseEntity<?> prenota(@RequestParam Long userId, @RequestParam Long postId, @RequestParam Integer days) {
		try {
			Prenotazione pr = this.pService.prenota(userId, postId, LocalDate.now().plusDays(days));
			return new ResponseEntity<Prenotazione>(pr, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


}
